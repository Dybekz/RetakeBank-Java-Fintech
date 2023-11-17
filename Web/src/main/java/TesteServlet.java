import br.com.fiap.javaTeste.dao.UsuarioDao;
import br.com.fiap.javaTeste.model.Usuario;
import br.com.fiap.javaTeste.dao.Conexao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TesteServlet")
public class TesteServlet extends HttpServlet {

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

        boolean isUserRegistered = false;
        try {
            isUserRegistered = usuarioDAO.existeUsuario(userEmail, userPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (isUserRegistered) {
            // Se o usuário estiver registrado, redirecione para a próxima página
            response.sendRedirect("index.jsp");
        } else {
            // Se o usuário não estiver registrado, exibe um pop-up de alerta e redirecione para a página de cadastro.
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Usuário não registrado ou senha incorreta.');");
            out.println("location='Login.jsp';");
            out.println("</script>");
        }
    }
}
