package br.com.fiap.javaTeste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.javaTeste.model.Conta;


public class ContaDao {
	
private Connection conexao;
	
	public ContaDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void gravar(Conta conta) {
		
		String sql = "INSERT INTO T_CONTA (id_conta, nome, saldo)"
				+ "VALUES (sq_conta.nextval, ? , ?)";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem gravados
			ps.setString(1, conta.getNome());
			ps.setDouble(2, conta.getSaldo());
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Conta cadastrada com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	public void deleteByID (int id) {
		
		String sql = "DELETE FROM t_conta WHERE id_conta = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//ID a ser deletado
			ps.setInt(1, id);
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Conta deletada com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	
	public void update(Conta conta) {
		
		String sql = "UPDATE t_conta SET nome = ?, saldo = ? "+
		 "WHERE id = ?";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem atualizados
			ps.setString(1, conta.getNome());
			ps.setDouble(2, conta.getSaldo());
			
			//Qual o ID que será atualizado
			ps.setInt(3, conta.getId_conta());
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Conta atualizada com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}
	
	public List<Conta> listarTodos () {
		
		//Select ALL ordenado em modo crescente
		String sql = "SELECT * FROM t_conta ORDER BY id_conta";
		
		List<Conta> contas = null;	

		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			contas = new ArrayList();
			
			//Loop com while feito para pegar todos os ID
			while (rs.next()) {
				
				Conta c = new Conta();
				c.setId_conta(rs.getInt("id_conta"));
				c.setNome(rs.getString("nome"));
				c.setSaldo(rs.getDouble("saldo"));
				contas.add(c);
			
			}
			
			ps.close();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
		return contas;
		
	}

	public void buscarContaPorId(int id_conta) {
	
	String sql = "SELECT * FROM t_conta WHERE id_conta = ? ";
	
	try {
		
		//Criar conexão com o banco
		PreparedStatement ps = conexao.prepareStatement(sql);
		
		//Qual ID será pesquisado
		ps.setInt(1, id_conta);

		ResultSet rs = ps.executeQuery();
		
		Conta c = new Conta();
		
		//Loop para pegar os dados pesquisados
		if (rs.next()) {
			
			c.setId_conta(rs.getInt("id_conta"));
			c.setNome(rs.getString("nome"));
			c.setSaldo(rs.getDouble("saldo"));
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
