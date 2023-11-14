package br.com.fiap.javaTeste;

import java.util.List;

import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.dao.InvestimentoDao;
import br.com.fiap.javaTeste.model.Investimento;


public class MainInvestimento {

	public static void main(String[] args) {

		//Adicionar um novo investimento
		Investimento investimento = new Investimento();
		investimento.setInvestimentos("NOME DO INVESTIMENTO");
		investimento.setSld_investimento(9999.9);//saldo referente ao investimento
				
		InvestimentoDao iDao = new InvestimentoDao(Conexao.abrirConexao());
		iDao.gravar(investimento);
				
		//Atualizar investimento
		Investimento i1 = new Investimento();
		i1.setInvestimentos("ATUALIZAR NOME DO INVESTIMENTO");
		i1.setSld_investimento(0);//Atualizar saldo do investimento
		i1.setId_investimento(0); //ID que está sendo mudado (PK)
		iDao.update(i1);
				
				
		//Deletar conta pelo numero de ID
		//iDao.deleteByID(0);//ID que desja excluir
				
				
		//Buscar contas por ID
		iDao.buscarInvestimentoPorId(0);
				
		//Listar todas as contas cadastradas
		List<Investimento> investimentos = iDao.listarTodos();
						
			for (Investimento i : investimentos) {
						System.out.println(i);
							
			}						
	}
		
}


