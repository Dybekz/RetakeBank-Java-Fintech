package br.com.fiap.javaTeste;


import java.util.Date;
import java.util.List;

import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.dao.UsuarioDao;
import br.com.fiap.javaTeste.model.Usuario;

public class Main {

	public static void main(String[] args) {
		
		
		//Adicionar um novo usuário
		Usuario usuario = new Usuario();
		usuario.setNome("NOME");
		usuario.setSenha("SENHA");
		usuario.setDt_nascimento(new Date(usuario.getDt_nascimento().getTime()));
		usuario.setEmail("EMAIL");
	
		UsuarioDao uDao = new UsuarioDao(Conexao.abrirConexao());
		uDao.gravar(usuario);  
		
		
		//Atualizar usuario
		Usuario u1 = new Usuario();
		u1.setNome("ATUALIZAR NOME");
		u1.setSenha("ATUALIZAR SENHA");
		u1.setEmail("ATUALIZAR EMAIL");
		u1.setDt_nascimento(new Date());
		u1.setId_usuario(42); //ID que está sendo mudado (PK)
		uDao.update(u1);
		
		
		//Deletar o usuario pelo numero de ID
		uDao.deleteByID(22);//ID que desja excluir
		
		
		//Buscar usuários por ID
		uDao.buscarUsuarioPorId(4);
		
		
		//Listar todos os usuários cadastrados
		List<Usuario> usuarios = uDao.listarTodos();
		
		for (Usuario u : usuarios) {
			System.out.println(u);
			
		}
	}
}

