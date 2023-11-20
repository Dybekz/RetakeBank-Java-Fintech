import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.javaTeste.dao.CartaoDao;
import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.model.Cartao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/CartaoServlet")
public class CartaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conexao = null;
        try {
            // Dados do formulário
            String nm_cartao = request.getParameter("nm_cartao");
            String nr_cartao = request.getParameter("nr_cartao");
            String vld_cartao = request.getParameter("vld_cartao");
            String cvv_cartao = request.getParameter("cvv_cartao");

            // Validação dos dados
            if (nm_cartao == null || nr_cartao == null || vld_cartao == null || cvv_cartao == null) {
                throw new ServletException("Todos os campos são obrigatórios.");
            }

            // Crie um objeto Cartao
            Cartao cartao = new Cartao();
            cartao.setNm_cartao(nm_cartao);
            cartao.setNr_cartao(nr_cartao);
            cartao.setVld_cartao(vld_cartao);
            cartao.setCvv_cartao(cvv_cartao);

            // Crie um objeto CartaoDao e grave o cartão no banco de dados
            conexao = Conexao.abrirConexao();
            CartaoDao cartaoDao = new CartaoDao(conexao);
            cartaoDao.gravar(cartao);

            // Enviar feedback ao usuário
            response.getWriter().println("Cartão cadastrado com sucesso!");

            // Redirecionar para index.jsp
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            // Tratamento de erro apropriado
            response.getWriter().println("Ocorreu um erro: " + e.getMessage());
        } finally {
            // Fechamento de recursos
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
