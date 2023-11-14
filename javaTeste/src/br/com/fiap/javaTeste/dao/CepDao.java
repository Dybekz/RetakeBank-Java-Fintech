package br.com.fiap.javaTeste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.javaTeste.model.Cep;

public class CepDao {
	
private Connection conexao;
	
	public CepDao(Connection conexao) {
		this.conexao = conexao;
	}	

	public void gravar(Cep cep) {
		
		String sql = "INSERT INTO t_investimento (id_cep, nr_cep)"
				+ "VALUES (sq_cep.nextval, ?)";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem gravados
			ps.setString(1, cep.getNr_cep());
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Cep cadastrado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}	

	public void deleteByID (int id) {
		
		String sql = "DELETE FROM t_cep WHERE id_cep = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//ID a ser deletado
			ps.setInt(1, id);
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Cep deletado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}	

	public void update(Cep cep) {
		
		String sql = "UPDATE t_cep SET nr_cep = ? "+
		 "WHERE id = ?";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem atualizados
			ps.setString(1, cep.getNr_cep());
			
			//Qual o ID que será atualizado
			ps.setInt(2, cep.getId_cep());
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Cep atualizado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}	

	public List<Cep> listarTodos () {
		
		//Select ALL ordenado em modo crescente
		String sql = "SELECT * FROM t_cep ORDER BY id_cep";
		
		List<Cep> ceps = null;	

		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			ceps = new ArrayList();
			
			//Loop com while feito para pegar todos os ID
			while (rs.next()) {
				
				Cep c = new Cep();
				c.setId_cep(rs.getInt("id_cep"));
				ceps.add(c);
			
			}
			
			ps.close();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
		return ceps;
		
	}
	
	public void buscarCepPorId(int id_cep) {
		
		String sql = "SELECT * FROM t_cep WHERE id_cep = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Qual ID será pesquisado
			ps.setInt(1, id_cep);

			ResultSet rs = ps.executeQuery();
			
			Cep c = new Cep();
			
			//Loop para pegar os dados pesquisados
			if (rs.next()) {
				
				c.setId_cep(rs.getInt("id_cep"));
				c.setNr_cep(rs.getString("nr_cep"));

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
