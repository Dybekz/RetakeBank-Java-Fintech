package br.com.fiap.javaTeste.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import br.com.fiap.javaTeste.model.Usuario;

public class UsuarioDao {

	private Connection conexao;

	public UsuarioDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void gravar(Usuario usuario) {

		String sql = "INSERT INTO T_USUARIO (id_usuario, nome, senha, email, sobrenome) "
				+ "VALUES (sq_usuario.nextval, ?, ?, ?,?)";

		try {

			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			//Valores à serem gravados
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getSobrenome());


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

	public void deleteByID(int id) {

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

		String sql = "UPDATE t_usuario SET nome = ?, senha = ?, email = ?, dt_nascimento = ? " +
				"WHERE id = ?";

		try {

			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);

			//Valores à serem atualizados
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getEmail());
			//ps.setDate(4, new Date(usuario.getDt_nascimento().getTime()));


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

	public List<Usuario> listarTodos() {

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

	public Usuario buscarUsuario(int id_usuario) {
		Usuario u = null;
		String sql = "SELECT * FROM T_USUARIO WHERE id_usuario  = ?";
		try {
			//Criar conexão com o banco
			PreparedStatement ps = conexao.prepareStatement(sql);
			//Qual ID será pesquisado
			ps.setInt(1, id_usuario);
			ResultSet rs = ps.executeQuery();
			//Loop para pegar os dados pesquisados
			if (rs.next()) {
				u = new Usuario();
				u.setId_usuario(rs.getInt("id_usuario"));
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				u.setEmail(rs.getString("email"));
				u.setDt_nascimento(rs.getDate("dt_nascimento"));
			}
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Ocorreu algum erro no sistema");
			e.printStackTrace();
		}
		return u;
	}

	public Usuario existeUsuario(String email, String senha) throws SQLException {
		Usuario usuario = null;
		String sql = "SELECT * FROM T_USUARIO WHERE email = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			// Recupera o "sal" e o hash da senha do banco de dados
			String[] parts = rs.getString("senha").split(":");
			String salt = parts[0];
			String storedHash = parts[1];

			// Calcula o hash da senha fornecida
			String hashedPassword = hashPassword(senha, salt);

			// Compara o hash da senha fornecida com o hash armazenado no banco de dados
			if (hashedPassword.equals(storedHash)) {
				usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
			}
		}
		rs.close();
		stmt.close();
		return usuario;

	}

	public String hashPassword(String password, String salt) {
		try {
			// Converte o "sal" de volta para bytes
			byte[] saltBytes = Base64.getDecoder().decode(salt);

			// Calcula o hash da senha
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(saltBytes);
			byte[] hashedPassword = md.digest(password.getBytes());

			// Converte o hash da senha para Base64 para comparação
			String passwordBase64 = Base64.getEncoder().encodeToString(hashedPassword);

			// Retorna o hash da senha
			return passwordBase64;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}


