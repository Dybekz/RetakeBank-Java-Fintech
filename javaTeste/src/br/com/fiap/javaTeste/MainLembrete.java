package br.com.fiap.javaTeste;

import java.util.List;

import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.dao.LembreteDao;
import br.com.fiap.javaTeste.model.Lembrete;


public class MainLembrete {

	public static void main(String[] args) {

		//Adicionar um novo Lembrete
		Lembrete lembrete = new Lembrete();
		lembrete.setGas("CONTA DE GÁS");
		lembrete.setLuz("CONTA DE LUZ");
		lembrete.setInternet("CONTA DE INTERNET");
		lembrete.setAgua("CONTA DE ÁGUA");
		lembrete.setFaculdade("MENSALIDADE DA FACULDADE");
		
		LembreteDao lDao = new LembreteDao(Conexao.abrirConexao());
		lDao.gravar(lembrete);
		
		//Atualizar lembretes
		Lembrete l1 = new Lembrete();
		l1.setGas("ATUALIZAR GÁS");
		l1.setLuz("ATUALIZAR LUZ");
		l1.setInternet("ATUALIZAR INTERNET");
		l1.setAgua("ATUALIZAR ÁGUA");
		l1.setFaculdade("ATUALIZAR FACULDADE");
		l1.setId_lembrete(0); //ID que está sendo mudado (PK)
		lDao.update(l1);
		
		
		//Deletar lembrete pelo numero de ID
		//lDao.deleteByID(0);//ID que desja excluir
		
		
		//Buscar lembretes por ID
		lDao.buscarLembretePorId(0);
		
		//Listar todos os lembretes cadastradas
		List<Lembrete> lembretes = lDao.listarTodos();
				
			for (Lembrete l : lembretes) {
				System.out.println(l);
					
			}						
	}		
		
}


