package br.com.fiap.javaTeste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.javaTeste.model.Endereco;

public class EnderecoDao {
	
private Connection conexao;
	
	public EnderecoDao(Connection conexao) {
		this.conexao = conexao;
	}	

	public void gravar(Endereco endereco) {
		
		String sql = "INSERT INTO t_endereco (id_endereco, rua , bairro, nr_casa, cidade, estado, complemento)"
				+ "VALUES (sq_endereco.nextval, ? , ?, ?, ?, ?, ?)";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem gravados
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getBairro());
			ps.setString(3, endereco.getNr_casa());
			ps.setString(4, endereco.getCidade());
			ps.setString(5, endereco.getEstado());
			ps.setString(6, endereco.getComplemento());
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Endereço cadastrado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	public void deleteByID (int id) {
		
		String sql = "DELETE FROM t_endereco WHERE id_endereco = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//ID a ser deletado
			ps.setInt(1, id);
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Endereço deletado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	public void update(Endereco endereco) {
		
		String sql = "UPDATE t_endereco SET rua = ?, bairro = ? nr_casa = ? cidade = ? estado = ? complemento = ? "+
		 "WHERE id = ?";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem atualizados
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getBairro());
			ps.setString(3, endereco.getNr_casa());
			ps.setString(4, endereco.getCidade());
			ps.setString(5, endereco.getEstado());
			ps.setString(6, endereco.getComplemento());
			
			
			//Qual o ID que será atualizado
			ps.setInt(7, endereco.getId_endereco());
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Endereço atualizado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	public List<Endereco> listarTodos () {
		
		//Select ALL ordenado em modo crescente
		String sql = "SELECT * FROM t_endereco ORDER BY id_endereco";
		
		List<Endereco> enderecos = null;	

		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			enderecos = new ArrayList();
			
			//Loop com while feito para pegar todos os ID
			while (rs.next()) {
				
				Endereco e = new Endereco();
				e.setId_endereco(rs.getInt("id_endereco"));
				e.setRua(rs.getString("rua"));
				e.setBairro(rs.getString("bairro"));
				e.setNr_casa(rs.getString("nr_casa"));
				e.setCidade(rs.getString("cidade"));
				e.setEstado(rs.getString("estado"));
				e.setComplemento(rs.getString("complemento"));
				enderecos.add(e);
			
			}
			
			ps.close();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
		return enderecos;
		
	}

	public void buscarEnderecoPorId(int id_endereco) {
		
		String sql = "SELECT * FROM t_endereco WHERE id_endereco = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Qual ID será pesquisado
			ps.setInt(1, id_endereco);

			ResultSet rs = ps.executeQuery();
			
			Endereco e = new Endereco();
			
			//Loop para pegar os dados pesquisados
			if (rs.next()) {
				
				e.setId_endereco(rs.getInt("id_endereco"));
				e.setRua(rs.getString("rua"));
				e.setBairro(rs.getString("bairro"));
				e.setNr_casa(rs.getString("nr_casa"));
				e.setCidade(rs.getString("cidade"));
				e.setEstado(rs.getString("estado"));
				e.setComplemento(rs.getString("complemento"));
				
			}
			
			System.out.println(e);
			
			ps.close();
			conexao.close();
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
	}
	
}
