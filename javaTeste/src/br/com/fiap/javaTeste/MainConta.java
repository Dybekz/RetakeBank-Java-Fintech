package br.com.fiap.javaTeste;

import java.util.List;

import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.dao.ContaDao;
import br.com.fiap.javaTeste.model.Conta;

public class MainConta {

	public static void main(String[] args) {
		
		//Adicionar um novo saldo
		Conta conta = new Conta();
		conta.setNome("TIPO DE CONTA");
		conta.setSaldo(9999.9);//saldo da conta
		
		ContaDao cDao = new ContaDao(Conexao.abrirConexao());
		cDao.gravar(conta);
		
		//Atualizar conta
		Conta c1 = new Conta();
		c1.setNome("ATUALIZAR TIPO DE CONTA");
		c1.setSaldo("ATUALIZAR SALDO");
		c1.setId_conta(0); //ID que está sendo mudado (PK)
		cDao.update(c1);
		
		
		//Deletar conta pelo numero de ID
		//cDao.deleteByID(0);//ID que desja excluir
		
		
		//Buscar contas por ID
		cDao.buscarContaPorId(0);
		
		//Listar todas as contas cadastradas
		List<Conta> contas = cDao.listarTodos();
				
			for (Conta c : contas) {
				System.out.println(c);
					
			}						
	}

}
