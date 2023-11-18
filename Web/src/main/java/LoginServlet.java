import br.com.fiap.javaTeste.dao.UsuarioDao;
import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.model.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private Connection myDatabaseConnection;

    public void init() throws ServletException {
        super.init();
        this.myDatabaseConnection = Conexao.abrirConexao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("typeEmailX");
        String userPassword = request.getParameter("typePasswordX");

        UsuarioDao usuarioDAO = new UsuarioDao(myDatabaseConnection);

        try {
            // Recupera o usuário do banco de dados
            Usuario usuario = usuarioDAO.existeUsuario(userEmail, userPassword);

            if (usuario != null && usuario.getSenha() != null) {
                // Divide a senha armazenada em "sal" e hash
                String[] parts = usuario.getSenha().split(":");
                String salt = parts[0];
                String storedHash = parts[1];

                // Calcula o hash da senha fornecida
                String hashedPassword = hashPassword(userPassword, salt);

                // Compara o hash da senha fornecida com o hash armazenado no banco de dados
                if (hashedPassword.equals(storedHash)) {
                    // Se o usuário estiver registrado, redirecione para a próxima página
                    response.sendRedirect("index.jsp");
                } else {
                    // Se a senha estiver incorreta, exibe um pop-up de alerta e redirecione para a página de login.
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Senha incorreta.');");
                    out.println("location='Login.jsp';");
                    out.println("</script>");
                }
            } else {
                // Se o usuário não estiver registrado, exibe um pop-up de alerta e redirecione para a página de cadastro.
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Usuário não registrado.');");
                out.println("location='Login.jsp';");
                out.println("</script>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String hashPassword(String password, String salt) {
        try {
            // Converte o "sal" de volta para bytes
            byte[] saltBytes = Base64.getDecoder().decode(salt);

            // Calcula o hash da senha
            MessageDigest md;
            md = MessageDigest.getInstance("SHA-256");
            md.update(saltBytes);
            byte[] hashedPassword = md.digest(password.getBytes());

            // Converte o hash da senha para Base64 para comparação
            String passwordBase64 = Base64.getEncoder().encodeToString(hashedPassword);

            // Retorna o hash da senha
            return passwordBase64;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
