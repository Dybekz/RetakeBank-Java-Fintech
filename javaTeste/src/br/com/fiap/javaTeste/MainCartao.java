package br.com.fiap.javaTeste;

import java.util.List;

import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.dao.CartaoDao;
import br.com.fiap.javaTeste.model.Cartao;

public class MainCartao {

	public static void main(String[] args) {

		//Adicionar um novo cartão
		Cartao cartao = new Cartao();
		cartao.setNm_cartao("NOME DO CARTÃO");
		cartao.setNr_cartao("NÚMERO DO CARTÃO");
		cartao.setVld_cartao("VALIDADE DO CARTÃO");
		cartao.setCvv_cartao("CVV DO CARTÃO");

				
		CartaoDao cDao = new CartaoDao(Conexao.abrirConexao());
		cDao.gravar(cartao);
				
		//Atualizar cartão
		Cartao c1 = new Cartao();
		c1.setNm_cartao("ATUALIZAR NOME NO CARTÃO");
		c1.setNr_cartao("ATUALIZAR NÚMERO DO CARTÃO");
		c1.setVld_cartao("ATUALIZAR VALIDADE DO CARTÃO");
		c1.setCvv_cartao("ATUALIZAR CVV DO CARTÃO");
		c1.setId_cartao(0); //ID que está sendo mudado (PK)
		cDao.update(c1);
				
				
		//Deletar cartão pelo numero de ID
		cDao.deleteByID(0);//ID que desja excluir
				
				
		//Buscar cartões por ID
		cDao.buscarCartaoPorId(0);
				
		//Listar todos os cartões cadastrados
		List<Cartao> cartoes = cDao.listarTodos();
						
			for (Cartao c : cartoes) {
						System.out.println(c);
							
			}			
		
	}
		
		
}


