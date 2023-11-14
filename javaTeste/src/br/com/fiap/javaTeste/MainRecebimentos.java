package br.com.fiap.javaTeste;

import java.util.List;

import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.dao.RecebimentosDao;
import br.com.fiap.javaTeste.model.Recebimentos;

public class MainRecebimentos {

	public static void main(String[] args) {

		//Adicionar novos recebimentos
		Recebimentos recebimentos = new Recebimentos();
		recebimentos.setSalario(9999.9);
		recebimentos.setRcb_extra(9999.9);//Rendas extras
				
		RecebimentosDao rDao = new RecebimentosDao(Conexao.abrirConexao());
		rDao.gravar(recebimentos);
				
		//Atualizar recebimentos
		Recebimentos r1 = new Recebimentos();
		r1.setSalario(0);//Atualizar salario
		r1.setRcb_extra(0);//Atualizar recebimentos extras
		r1.setId_recebimentos(0); //ID que está sendo mudado (PK)
		rDao.update(r1);
				
				
		//Deletar recebimentos pelo numero de ID
		//rDao.deleteByID(0);//ID que desja excluir
				
				
		//Buscar recebimentos por ID
		rDao.buscarRecebimentosPorId(0);
				
		//Listar todas os recebimentos cadastrados
		List<Recebimentos> recebimentos1 = rDao.listarTodos();
						
			for (Recebimentos r : recebimentos1) {
				System.out.println(r);
							
			}						
	}
		
}


