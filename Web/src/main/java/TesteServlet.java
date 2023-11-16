import br.com.fiap.javaTeste.dao.UsuarioDao;
import br.com.fiap.javaTeste.model.Usuario;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Teste.html")
public class TesteServlet extends HttpServlet {

    private Connection myDatabaseConnection;
    private java.sql.Connection Connection;

    public void init() throws ServletException {
        super.init();
        Connection nomeConexao = Connection;
        this.myDatabaseConnection = nomeConexao;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("typeEmailX");
        String userPassword = request.getParameter("typePasswordX");

        UsuarioDao usuarioDAO = new UsuarioDao (myDatabaseConnection);
        Usuario usuario = UsuarioDao.buscarUsuario();

        boolean isUserRegistered = usuarioDAO.listarTodos(userEmail, userPassword);

        if (isUserRegistered) {
            // Se o usuário estiver registrado, redirecione para a próxima página
            response.sendRedirect("index.jsp");
        } else {
            // Se o usuário não estiver registrado, redirecione para a página de cadastro.
            response.sendRedirect("TelaLogin.html");
        }
    }

    private boolean checkDatabaseForUser(String email, String password) {
        UsuarioDao usuarioDAO = new UsuarioDao(myDatabaseConnection);
        return usuarioDAO.existeUsuario(email, password);
    }
}
