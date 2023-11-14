package br.com.fiap.javaTeste;

import java.util.Date;
import java.util.List;

import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.dao.TransacaoDao;
import br.com.fiap.javaTeste.model.Transacao;

public class MainTransacao {

	public static void main(String[] args) {
		
		//Adicionar um novo saldo
		Transacao transacao = new Transacao();
		transacao.setData(new Date(transacao.getData().getTime()));
		transacao.setValor(9999.9);//Valor da transação
		transacao.setTipo("TIPO DA TRANSAÇÃO");//TED, DOC, PIX
		transacao.setDescricao("DESCRIÇÃO DA TRANSAÇÃO");//Mensagem enviada junto com a transação
				
		TransacaoDao tDao = new TransacaoDao(Conexao.abrirConexao());
		tDao.gravar(transacao);
				
		//Atualizar conta
		Transacao t1 = new Transacao();
		t1.setData(new Date(transacao.getData().getTime()));
		t1.setValor(9999.9);
		t1.setTipo("ATUAZALIAR TIPO");
		t1.setDescricao("ATUALIZAR DESCRIÇÃO");
		t1.setId_transacao(0); //ID que está sendo mudado (PK)
		tDao.update(t1);
				
				
		//Deletar conta pelo numero de ID
		//tDao.deleteByID(0);//ID que desja excluir
				
				
		//Buscar contas por ID
		tDao.buscarTransacaoPorId(0);
				
		//Listar todas as contas cadastradas
		List<Transacao> transacao1 = tDao.listarTodos();
						
			for (Transacao t : transacao1) {
						System.out.println(t);
							
			}						
	}

		

}


