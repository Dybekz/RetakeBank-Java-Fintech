package web.retakeBank.servlets;

import br.com.fiap.javaTeste.dao.Conexao;

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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

@WebServlet("/TelaLogin")
public class TelaLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String primeiroNome = request.getParameter("PrimeiroNome");
        String sobrenome = request.getParameter("Sobrenome");
        String email = request.getParameter("Email");
        String senha = request.getParameter("Senha");

        // Hash da senha para segurança
        String hashedPassword = hashPassword(senha);

        // Conexão com o banco de dados
        Connection conn = getMyDatabaseConnection();
        String sql = "INSERT INTO T_USUARIO (primeiroNome, sobrenome, email, senha) VALUES (?, ?, ?, ?)";

        // Preparar a declaração SQL
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, primeiroNome);
            stmt.setString(2, sobrenome);
            stmt.setString(3, email);
            stmt.setString(4, hashedPassword);

            // Executar a declaração SQL
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException("Erro ao salvar o usuário no banco de dados", e);
        }

        // Redirecionar o usuário para a página de destino após o login bem-sucedido.
        response.sendRedirect("success.jsp");
    }

    public String hashPassword(String password) {
        try {
            // Crie um "sal" aleatório
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            // Crie o hash da senha
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());

            // Converta o "sal" e a senha para Base64 para armazenamento
            String saltBase64 = Base64.getEncoder().encodeToString(salt);
            String passwordBase64 = Base64.getEncoder().encodeToString(hashedPassword);

            // Retorne o "sal" e a senha como uma string concatenada
            return saltBase64 + ":" + passwordBase64;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getMyDatabaseConnection() {
        return Conexao.abrirConexao();
    }

}
