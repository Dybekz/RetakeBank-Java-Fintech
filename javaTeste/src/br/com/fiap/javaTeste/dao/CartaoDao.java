package br.com.fiap.javaTeste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.javaTeste.model.Cartao;

public class CartaoDao {
	
private Connection conexao;
	
	public CartaoDao(Connection conexao) {
		this.conexao = conexao;
	}		
	
	public void gravar(Cartao cartao) {
		
		String sql = "INSERT INTO t_cartao (id_cartao, nm_cartao , nr_cartao , vld_cartao , cvv_cartao)"
				+ "VALUES (sq_cartao.nextval, ? , ?, ?, ?)";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem gravados
			ps.setString(1, cartao.getNm_cartao());
			ps.setString(2, cartao.getNr_cartao());
			ps.setString(3, cartao.getVld_cartao());
			ps.setString(4, cartao.getCvv_cartao());
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Cartão cadastrado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	public void deleteByID (int id) {
		
		String sql = "DELETE FROM t_cartao WHERE id_cartao = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//ID a ser deletado
			ps.setInt(1, id);
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Cartão deletado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	public void update(Cartao cartao) {

		String sql = "UPDATE t_cartao SET nm_cartao = ?, nr_cartao = ?, vld_cartao = ?, cvv_cartao = ? " +
		 "WHERE id = ?";

		try {

			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			//Valores à serem atualizados
			ps.setString(1, cartao.getNm_cartao());
			ps.setString(2, cartao.getNr_cartao());
			ps.setString(3, cartao.getVld_cartao());
			ps.setString(4, cartao.getCvv_cartao());


			//Qual o ID que será atualizado
			ps.setInt(5, cartao.getId_cartao());

			//Execução do comando
			ps.execute();

			ps.close();
			conexao.close();

			System.out.println("Cartão atualizado com sucesso!");


		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}

	}

	public List<Cartao> listarTodos () {
		
		//Select ALL ordenado em modo crescente
		String sql = "SELECT * FROM t_cartao ORDER BY id_cartao";
		
		List<Cartao> cartoes = null;	

		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			cartoes = new ArrayList();
			
			//Loop com while feito para pegar todos os ID
			while (rs.next()) {
				
				Cartao c = new Cartao();
				c.setId_cartao(rs.getInt("id_cartao"));
				c.setNm_cartao(rs.getString("nm_cartao"));
				c.setNr_cartao(rs.getString("nr_cartao"));
				c.setVld_cartao(rs.getString("vld_cartao"));
				c.setCvv_cartao(rs.getString("cvv_cartao"));
				cartoes.add(c);
			
			}
			
			ps.close();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
		return cartoes;
		
	}	

	public void buscarCartaoPorId(int id_cartao) {
		
		String sql = "SELECT * FROM t_cartao WHERE id_cartao = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Qual ID será pesquisado
			ps.setInt(1, id_cartao);

			ResultSet rs = ps.executeQuery();
			
			Cartao c = new Cartao();
			
			//Loop para pegar os dados pesquisados
			if (rs.next()) {
				
				c.setId_cartao(rs.getInt("id_cartao"));
				c.setNm_cartao(rs.getString("nm_cartao"));
				c.setNr_cartao(rs.getString("nr_cartao"));
				c.setVld_cartao(rs.getString("vld_cartao"));
				c.setCvv_cartao(rs.getString("cvv_cartao"));
				
			}
			
			System.out.println(c);
			
			ps.close();
			conexao.close();
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
	}	
	
}
