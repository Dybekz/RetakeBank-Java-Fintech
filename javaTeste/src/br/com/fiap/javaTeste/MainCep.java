package br.com.fiap.javaTeste;

import java.util.List;

import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.dao.CepDao;
import br.com.fiap.javaTeste.model.Cep;

public class MainCep {

	public static void main(String[] args) {

		//Adicionar um novo cep
		Cep cep = new Cep();
		cep.setNr_cep("NÚMERO DO CEP");
				
		CepDao cDao = new CepDao(Conexao.abrirConexao());
		cDao.gravar(cep);
				
		//Atualizar cep
		Cep c1 = new Cep();
		c1.setNr_cep("ATUALIZAR CEP");
		c1.setId_cep(0); //ID que está sendo mudado (PK)
		cDao.update(c1);
				
				
		//Deletar cep pelo numero de ID
		cDao.deleteByID(0);//ID que desja excluir
				
				
		//Buscar cep por ID
		cDao.buscarCepPorId(0);
				
		//Listar todas os ceps cadastradas
		List<Cep> ceps = cDao.listarTodos();
						
			for (Cep c : ceps) {
						System.out.println(c);
			}				

	}									
}	
