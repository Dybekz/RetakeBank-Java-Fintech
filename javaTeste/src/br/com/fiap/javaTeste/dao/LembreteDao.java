package br.com.fiap.javaTeste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.javaTeste.model.Lembrete;

public class LembreteDao {
	
private Connection conexao;
	
	public LembreteDao(Connection conexao) {
		this.conexao = conexao;
	}	

	public void gravar(Lembrete lembrete) {
		
		String sql = "INSERT INTO T_LEMBRETE (id_lembrete, gas, luz, internet, agua, faculdade)"
				+ "VALUES (sq_lembrete.nextval, ? , ?, ?, ?, ?)";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem gravados
			ps.setString(1, lembrete.getGas());
			ps.setString(2, lembrete.getLuz());
			ps.setString(3, lembrete.getInternet());
			ps.setString(4, lembrete.getAgua());
			ps.setString(5, lembrete.getFaculdade());
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Lembrete cadastrado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	public void deleteByID (int id) {
		
		String sql = "DELETE FROM t_lembrete WHERE id_lembrete = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//ID a ser deletado
			ps.setInt(1, id);
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Lembrete deletada com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	public void update(Lembrete lembrete) {
		
		String sql = "UPDATE t_lembrete SET gas = ?, luz = ?, internet = ?, agua = ?, faculdade = ?"+
		 "WHERE id = ?";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem atualizados
			ps.setString(1, lembrete.getGas());
			ps.setString(2, lembrete.getLuz());
			ps.setString(3, lembrete.getInternet());
			ps.setString(4, lembrete.getAgua());
			ps.setString(5, lembrete.getFaculdade());
			
			//Qual o ID que será atualizado
			ps.setInt(6, lembrete.getId_lembrete());
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Lembrete atualizada com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}

	public List<Lembrete> listarTodos () {
		
		//Select ALL ordenado em modo crescente
		String sql = "SELECT * FROM t_lembrete ORDER BY id_lembrete";
		
		List<Lembrete> lembretes = null;	

		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			lembretes = new ArrayList();
			
			//Loop com while feito para pegar todos os ID
			while (rs.next()) {
				
				Lembrete l = new Lembrete();
				l.setId_lembrete(rs.getInt("id_lembrete"));
				l.setGas(rs.getString("gas"));
				l.setLuz(rs.getString("luz"));
				l.setInternet(rs.getString("internet"));
				l.setAgua(rs.getString("agua"));
				l.setFaculdade(rs.getString("faculdade"));
				lembretes.add(l);
			
			}
			
			ps.close();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
		return lembretes;
		
	}

	public void buscarLembretePorId(int id_lembrete) {
		
	String sql = "SELECT * FROM t_lembrete WHERE id_lembrete = ? ";
	
	try {
		
		//Criar conexão com o banco
		PreparedStatement ps = conexao.prepareStatement(sql);
		
		//Qual ID será pesquisado
		ps.setInt(1, id_lembrete);

		ResultSet rs = ps.executeQuery();
		
		Lembrete l = new Lembrete();
		
		//Loop para pegar os dados pesquisados
		if (rs.next()) {
			
			l.setId_lembrete(rs.getInt("id_lembrete"));
			l.setGas(rs.getString("gas"));
			l.setLuz(rs.getString("luz"));
			l.setInternet(rs.getString("internet"));
			l.setAgua(rs.getString("agua"));
			l.setFaculdade(rs.getString("faculdade"));
		}
		
		System.out.println(l);
		
		ps.close();
		conexao.close();
		
		
		
		
	} catch (SQLException e) {
		System.out.println("Ocorreu algum erro no sistema");
		e.printStackTrace();
	}
}
	

}

