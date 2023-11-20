/**
 * Não esquecer, criar servlet contendo os seguintes métodos
 * buscar saldo por id do usuario que está na sessão
 * transferir valores, recebimentos
 */

package br.com.fiap.javaTeste.servlet;

import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.model.Recebimentos;
import br.com.fiap.javaTeste.model.Transacao;
import br.com.fiap.javaTeste.dao.RecebimentosDao;
import br.com.fiap.javaTeste.dao.TransacaoDao;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/SaldoServlet")
public class SaldoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Crie um novo objeto Recebimentos
        Recebimentos recebimentos = new Recebimentos();
        recebimentos.setSalario(Double.parseDouble(request.getParameter("salario")));
        recebimentos.setRcb_extra(Double.parseDouble(request.getParameter("rcb_extra")));

        // Crie um novo objeto Transacao
        Transacao transacao = new Transacao();
        transacao.setValor(Double.parseDouble(request.getParameter("valor")));
        transacao.setTipo(request.getParameter("tipo"));
        transacao.setDescricao(request.getParameter("descricao"));

        // Crie uma conexão com o banco de dados
        Connection conexao = Conexao.abrirConexao();

        // Crie um novo objeto RecebimentosDao e TransacaoDao
        RecebimentosDao recebimentosDao = new RecebimentosDao(conexao);
        TransacaoDao transacaoDao = new TransacaoDao(conexao);

        // Use o RecebimentosDao e TransacaoDao para gravar os objetos no banco de dados
        recebimentosDao.gravar(recebimentos);
        transacaoDao.gravar(transacao);

        // Enviar resposta para o cliente
        PrintWriter out = response.getWriter();
        out.println("Recebimentos: " + recebimentos.toString());
        out.println("Transacao: " + transacao.toString());
    }
}

