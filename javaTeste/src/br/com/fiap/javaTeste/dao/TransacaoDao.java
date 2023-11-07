package br.com.fiap.javaTeste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.javaTeste.model.Transacao;

public class TransacaoDao {
	
	private Connection conexao;

	public TransacaoDao(Connection conexao) {
		this.conexao = conexao;
	}
	public void gravar(Transacao transacao) {
		
		String sql = "INSERT INTO t_transacao (id_transacao, data, valor, tipo, descricao)"
				+ "VALUES (sq_transacao.nextval, ? , ?, ?, ?)";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem gravados
			ps.setDate(1, (java.sql.Date) new Date(transacao.getData().getTime()));
			ps.setDouble(2, transacao.getValor());
			ps.setString(3, transacao.getTipo());
			ps.setString(4, transacao.getDescricao());
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Transação feita com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}
	
	public void deleteByID (int id) {
		
		String sql = "DELETE FROM t_transacao WHERE id_transacao = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//ID a ser deletado
			ps.setInt(1, id);
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Transação deletada com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}
	
	public void update(Transacao transacao) {
		
		String sql = "UPDATE t_transacao SET data = ?, valor = ?, tipo = ?, descricao = ?"+
		 "WHERE id = ?";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem atualizados
			ps.setDate(1, (java.sql.Date) new Date(transacao.getData().getTime()));
			ps.setDouble(2, transacao.getValor());
			ps.setString(3, transacao.getTipo());
			ps.setString(4, transacao.getDescricao());
			
			
			//Qual o ID que será atualizado
			ps.setInt(5, transacao.getId_transacao());
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Transação atualizada com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	public List<Transacao> listarTodos () {
		
		//Select ALL ordenado em modo crescente
		String sql = "SELECT * FROM t_transacao ORDER BY id_transacao";
		
		List<Transacao> transacao1 = null;	

		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			transacao1 = new ArrayList();
			
			//Loop com while feito para pegar todos os ID
			while (rs.next()) {
				
				Transacao t = new Transacao();
				t.setId_transacao(rs.getInt("id_transacao"));
				t.setData(rs.getDate("data"));
				t.setValor(rs.getDouble("valor"));
				t.setTipo(rs.getString("tipo"));
				t.setDescricao(rs.getString("descricao"));
				transacao1.add(t);
			
			}
			
			ps.close();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
		return transacao1;
		
	}
	
	public void buscarTransacaoPorId(int id_transacao) {
		
		String sql = "SELECT * FROM t_transacao WHERE id_transacao = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Qual ID será pesquisado
			ps.setInt(1, id_transacao);

			ResultSet rs = ps.executeQuery();
			
			Transacao t = new Transacao();
			
			//Loop para pegar os dados pesquisados
			if (rs.next()) {
				
				t.setId_transacao(rs.getInt("id_transacao"));
				t.setData(rs.getDate("data"));
				t.setValor(rs.getDouble("valor"));
				t.setTipo(rs.getString("tipo"));
				t.setDescricao(rs.getString("descricao"));			}
			
			System.out.println(t);
			
			ps.close();
			conexao.close();
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
	}
		




}
