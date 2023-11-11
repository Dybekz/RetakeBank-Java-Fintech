package br.com.fiap.javaTeste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.javaTeste.model.Telefone;

public class TelefoneDao {

private Connection conexao;
	
	public TelefoneDao(Connection conexao) {
		this.conexao = conexao;
	}	
	
	public void gravar(Telefone telefone) {
		
		String sql = "INSERT INTO T_TELEFONE (id_telefone, nr_telefone)"
				+ "VALUES (sq_telefone.nextval, ? )";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem gravados
			ps.setString(1, telefone.getNr_telefone());
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Telefone cadastrado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	public void deleteByID (int id) {
		
		String sql = "DELETE FROM t_telefone WHERE id_telefone = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//ID a ser deletado
			ps.setInt(1, id);
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Telefone deletado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}	

	public void update(Telefone telefone) {
		
		String sql = "UPDATE t_telefone SET nr_telefone = ? "+
		 "WHERE id = ?";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem atualizados
			ps.setString(1, telefone.getNr_telefone());
			
			//Qual o ID que será atualizado
			ps.setInt(2, telefone.getId_telefone());
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Telefone atualizado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}	

	public List<Telefone> listarTodos () {
		
		//Select ALL ordenado em modo crescente
		String sql = "SELECT * FROM t_telefone ORDER BY id_telefone";
		
		List<Telefone> telefones = null;	

		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			telefones = new ArrayList();
			
			//Loop com while feito para pegar todos os ID
			while (rs.next()) {
				
				Telefone t = new Telefone();
				t.setId_telefone(rs.getInt("id_telefone"));
				t.setNr_telefone(rs.getString("nr_telefone"));
				telefones.add(t);
			
			}
			
			ps.close();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
		return telefones;
		
	}	

	public void buscarTelefonePorId(int id_telefone) {
		
	String sql = "SELECT * FROM t_telefone WHERE id_telefone = ? ";
	
	try {
		
		//Criar conexão com o banco
		PreparedStatement ps = conexao.prepareStatement(sql);
		
		//Qual ID será pesquisado
		ps.setInt(1, id_telefone);

		ResultSet rs = ps.executeQuery();
		
		Telefone t = new Telefone();
		
		//Loop para pegar os dados pesquisados
		if (rs.next()) {
			
			t.setId_telefone(rs.getInt("id_telefone"));
			t.setNr_telefone(rs.getString("nr_telefone"));
		}
		
		System.out.println(t);
		
		ps.close();
		conexao.close();
		
		
		
		
	} catch (SQLException e) {
		System.out.println("Ocorreu algum erro no sistema");
		e.printStackTrace();
	}
}
	
}
