
import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.model.Investimento;
import br.com.fiap.javaTeste.dao.InvestimentoDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@WebServlet("/InvestimentoServlet")
public class InvestimentoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Novo objeto Investimento
        Investimento investimento = new Investimento();

        // Objeto com os dados da requisição
        investimento.setInvestimentos(request.getParameter("investimentos"));
        investimento.setSld_investimento(Double.parseDouble(request.getParameter("sld_investimento")));

        // Conexão com o banco de dados
        Connection conexao = Conexao.abrirConexao();

        InvestimentoDao investimentoDao = new InvestimentoDao(conexao);

        investimentoDao.gravar(investimento);

        // Enviar resposta para o cliente
        PrintWriter out = response.getWriter();
        out.println(investimento);
    }
}
