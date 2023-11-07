package br.com.fiap.javaTeste.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.javaTeste.model.Usuario;

public class UsuarioDao {
	
	private Connection conexao;
	
	public UsuarioDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void gravar(Usuario usuario) {
		
		String sql = "INSERT INTO T_USUARIO (id_usuario, nome, senha, email, dt_nascimento) "
				+ "VALUES (sq_usuario.nextval, ?, ?, ?, ?)";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem gravados
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getEmail());
			ps.setDate(4, new Date(usuario.getDt_nascimento().getTime()));
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Usuário cadastrado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}
	
	public void deleteByID (int id) {
		
		String sql = "DELETE FROM t_usuario WHERE id_usuario = ? ";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//ID a ser deletado
			ps.setInt(1, id);
			
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Usuário deletado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
		
		
	}
	
	public void update(Usuario usuario) {
		
		String sql = "UPDATE t_usuario SET nome = ?, senha = ?, email = ?, dt_nascimento = ? "+
		 "WHERE id = ?";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Valores à serem atualizados
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getEmail());
			ps.setDate(4, new Date(usuario.getDt_nascimento().getTime()));
			
			
			//Qual o ID que será atualizado
			ps.setInt(5, usuario.getId_usuario());
			
			//Execução do comando
			ps.execute();
			
			ps.close();
			conexao.close();
			
			System.out.println("Usuário atualizado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
	}
	
	public List<Usuario> listarTodos () {
		
		//Select ALL ordenado em modo crescente
		String sql = "SELECT * FROM T_USUARIO ORDER BY id_usuario";
		
		List<Usuario> usuarios = null;	

		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			usuarios = new ArrayList();
			
			//Loop com while feito para pegar todos os ID
			while (rs.next()) {
				
				Usuario u = new Usuario();
				u.setId_usuario(rs.getInt("id_usuario"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				u.setEmail(rs.getString("email"));
				u.setDt_nascimento(rs.getDate("dt_nascimento"));
				usuarios.add(u);
			
			}
			
			ps.close();
			conexao.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		
		return usuarios;
		
	}
	
	public void buscarUsuarioPorId(int id_usuario) {
		
		String sql = "SELECT * FROM T_USUARIO WHERE id_usuario = ?";
		
		try {
			
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			//Qual ID será pesquisado
			ps.setInt(1, id_usuario);

			ResultSet rs = ps.executeQuery();
			
			Usuario u = new Usuario();
			
			//Loop para pegar os dados pesquisados
			if (rs.next()) {
				
				u.setId_usuario(rs.getInt("id_usuario"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				u.setEmail(rs.getString("email"));
				u.setDt_nascimento(rs.getDate("dt_nascimento"));
			}
			
			System.out.println(u);
			
			ps.close();
			conexao.close();
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
	}


}
