package br.com.fiap.javaTeste;

import java.util.List;

import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.dao.TelefoneDao;
import br.com.fiap.javaTeste.model.Telefone;


public class MainTelefone {

	public static void main(String[] args) {

		//Adicionar um novo telefone
		Telefone telefone = new Telefone();
		telefone.setNr_telefone("NÚMERO DO TELEFONE");
				
		TelefoneDao telefoneDao = new TelefoneDao(Conexao.abrirConexao());
		telefoneDao.gravar(telefone);
				
		//Atualizar telefone
		Telefone telefone1 = new Telefone();
		telefone1.setNr_telefone("ATUALIZAR NÚMERO DE TELEFONE");
		telefone1.setId_telefone(0); //ID que está sendo mudado (PK)
		telefoneDao.update(telefone1);
				
				
		//Deletar telefone pelo numero de ID
		//telefoneDao.deleteByID(0);//ID que desja excluir
				
				
		//Buscar telefones por ID
		telefoneDao.buscarTelefonePorId(0);
				
		//Listar todos os telefones cadastrados
		List<Telefone> telefones = telefoneDao.listarTodos();
						
			for (Telefone t : telefones) {
						System.out.println(t);
							
			}						
	}
		
}

