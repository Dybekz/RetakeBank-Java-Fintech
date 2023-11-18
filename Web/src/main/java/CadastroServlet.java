import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.dao.UsuarioDao;
import br.com.fiap.javaTeste.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
    private Connection myDatabaseConnection;
    private static final Logger LOGGER = Logger.getLogger(CadastroServlet.class.getName());

    public void init() throws ServletException {
        super.init();
        try {
            this.myDatabaseConnection = Conexao.abrirConexao();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    public void destroy() {
        try {
            if (myDatabaseConnection != null) {
                myDatabaseConnection.close();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao fechar a conexão com o banco de dados", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String primeiroNome = request.getParameter("PrimeiroNome");
        String sobrenome = request.getParameter("Sobrenome");
        String email = request.getParameter("Email");
        String senha = request.getParameter("Senha");

        if (senha != null) {
            // Hash da senha para segurança
            String hashedPassword = hashPassword(senha);

            // Conexão com o banco de dados
            UsuarioDao conexao = new UsuarioDao(myDatabaseConnection);

            Usuario usuario = new Usuario();
            usuario.setNome(primeiroNome + " " + sobrenome);
            usuario.setSenha(hashedPassword);
            usuario.setEmail(email);

            conexao.gravar(usuario);

            // Redirecionar o usuário para a página de destino após o login bem-sucedido.
            response.sendRedirect("success.jsp");
        } else {
            // Tratar o caso em que a senha é nula
            LOGGER.log(Level.SEVERE, "A senha não foi fornecida");
        }
    }

    public String hashPassword(String password) {
        try {
            // Criado um "sal" aleatório
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            // Criado o hash da senha
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());

            // Convertido o "sal" e a senha para Base64 para armazenamento
            String saltBase64 = Base64.getEncoder().encodeToString(salt);
            String passwordBase64 = Base64.getEncoder().encodeToString(hashedPassword);

            // Retornado o "sal" e a senha como uma string concatenada
            return saltBase64 + ":" + passwordBase64;
        } catch (NoSuchAlgorithmException e) {
            LOGGER.log(Level.SEVERE, "Erro ao criar o hash da senha", e);
            throw new RuntimeException(e);
        }
    }
}
