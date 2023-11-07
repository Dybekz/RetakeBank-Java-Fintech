package br.com.fiap.javaTeste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.javaTeste.model.Investimento;

public class InvestimentoDao {
	
private Connection conexao;
	
	public InvestimentoDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void gravar(Investimento investimento) {
		
		String sql = "INSERT INTO t_investimento (id_investimento, investimentos, sld_investimento)"
				+ "VALUES (sq_investimento.nextval, ? , ?)";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem gravados
			ps.setString(1, investimento.getInvestimentos());
			ps.setDouble(2, investimento.getSld_investimento());
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Investimento cadastrado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}
	
	public void deleteByID (int id) {
	
		String sql = "DELETE FROM t_investimento WHERE id_investimento = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//ID a ser deletado
			ps.setInt(1, id);
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Investimento deletado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}
	
	public void update(Investimento investimento) {
		
		String sql = "UPDATE t_investimento SET investimentos = ?, sld_investimento = ? "+
		 "WHERE id = ?";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem atualizados
			ps.setString(1, investimento.getInvestimentos());
			ps.setDouble(2, investimento.getSld_investimento());
			
			//Qual o ID que será atualizado
			ps.setInt(3, investimento.getId_investimento());
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Investimento atualizado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	public List<Investimento> listarTodos () {
		
		//Select ALL ordenado em modo crescente
		String sql = "SELECT * FROM t_investimento ORDER BY id_investimento";
		
		List<Investimento> investimentos = null;	

		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			investimentos = new ArrayList();
			
			//Loop com while feito para pegar todos os ID
			while (rs.next()) {
				
				Investimento i = new Investimento();
				i.setId_investimento(rs.getInt("id_investimento"));
				i.setInvestimentos(rs.getString("investimentos"));
				i.setSld_investimento(rs.getDouble("sld_investimento"));
				investimentos.add(i);
			
			}
			
			ps.close();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
		return investimentos;
		
	}
	
	public void buscarInvestimentoPorId(int id_investimento) {
		
		String sql = "SELECT * FROM t_investimento WHERE id_investimento = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Qual ID será pesquisado
			ps.setInt(1, id_investimento);

			ResultSet rs = ps.executeQuery();
			
			Investimento i = new Investimento();
			
			//Loop para pegar os dados pesquisados
			if (rs.next()) {
				
				i.setId_investimento(rs.getInt("id_investimento"));
				i.setInvestimentos(rs.getString("investimentos"));
				i.setSld_investimento(rs.getDouble("saldo"));
			}
			
			System.out.println(i);
			
			ps.close();
			conexao.close();
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
	}



}
