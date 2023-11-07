package br.com.fiap.javaTeste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.javaTeste.model.Recebimentos;

public class RecebimentosDao {
	
private Connection conexao;
	
	public RecebimentosDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	public void gravar(Recebimentos recebimentos) {
	
		String sql = "INSERT INTO t_recebimentos (id_recebimentos, salario, rcb_extra)"
				+ "VALUES (sq_recebimentos.nextval, ? , ?)";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem gravados
			ps.setDouble(1, recebimentos.getSalario());
			ps.setDouble(2, recebimentos.getRcb_extra());
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Recebimentos cadastrados com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}
	
	
	public void deleteByID (int id) {
		
		String sql = "DELETE FROM t_recebimentos WHERE id_recebimentos = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//ID a ser deletado
			ps.setInt(1, id);
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Recebimentos deletados com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}
	
	public void update(Recebimentos recebimentos) {
		
		String sql = "UPDATE t_recebimentos SET salario = ?, rcb_extra = ? "+
		 "WHERE id = ?";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem atualizados
			ps.setDouble(1, recebimentos.getSalario());
			ps.setDouble(2, recebimentos.getRcb_extra());
			
			//Qual o ID que será atualizado
			ps.setInt(3, recebimentos.getId_recebimentos());
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Recebimentos atualizados com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}
	
	public List<Recebimentos> listarTodos () {
		
		//Select ALL ordenado em modo crescente
		String sql = "SELECT * FROM t_recebimentos ORDER BY id_recebimentos";
		
		List<Recebimentos> recebimentos1 = null;	

		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			recebimentos1 = new ArrayList();
			
			//Loop com while feito para pegar todos os ID
			while (rs.next()) {
				
				Recebimentos r = new Recebimentos();
				r.setId_recebimentos(rs.getInt("id_recebimentos"));
				r.setSalario(rs.getDouble("Salario"));
				r.setRcb_extra(rs.getDouble("Rcb_extra"));
				recebimentos1.add(r);
			
			}
			
			ps.close();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
		return recebimentos1;
		
	}
	
	public void buscarRecebimentosPorId(int id_recebimentos) {
		
	String sql = "SELECT * FROM t_recebimentos WHERE id_recebimentos = ? ";
	
	try {
		
		//Criar conexão com o banco
		PreparedStatement ps = conexao.prepareStatement(sql);
		
		//Qual ID será pesquisado
		ps.setInt(1, id_recebimentos);

		ResultSet rs = ps.executeQuery();
		
		Recebimentos r = new Recebimentos();
		
		//Loop para pegar os dados pesquisados
		if (rs.next()) {
			
			r.setId_recebimentos(rs.getInt("id_recebimentos"));
			r.setSalario(rs.getDouble("salario"));
			r.setRcb_extra(rs.getDouble("rcb_extra"));
		}
		
		System.out.println(r);
		
		ps.close();
		conexao.close();
		
		
		
		
	} catch (SQLException e) {
		System.out.println("Ocorreu algum erro no sistema");
		e.printStackTrace();
	}
}
		
	

}
