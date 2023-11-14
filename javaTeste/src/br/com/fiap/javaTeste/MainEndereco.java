package br.com.fiap.javaTeste;

import java.util.List;

import br.com.fiap.javaTeste.dao.Conexao;
import br.com.fiap.javaTeste.dao.EnderecoDao;
import br.com.fiap.javaTeste.model.Endereco;

public class MainEndereco {

	public static void main(String[] args) {

		//Adicionar um novo endereço
		Endereco endereco = new Endereco();
		endereco.setRua("NOME DA RUA");
		endereco.setBairro("NOME DO BAIRRO");
		endereco.setNr_casa("NÚMERO DA CASA");
		endereco.setCidade("NOME DA CIDADE");
		endereco.setEstado("NOME DO ESTADO");
		endereco.setComplemento("COMPLEMENTO");

				
		EnderecoDao eDao = new EnderecoDao(Conexao.abrirConexao());
		eDao.gravar(endereco);
				
		//Atualizar endereço
		Endereco e1 = new Endereco();
		e1.setRua("ATUALIZAR NOME DA RUA");
		e1.setBairro("ATUALIZAR NOME DO BAIRRO");
		e1.setNr_casa("ATUALIZAR NÚMERO DA CASA");
		e1.setCidade("ATUALIZAR NOME DA CIDADE");
		e1.setEstado("ATUALIZAR NOME DO ESTADO");
		e1.setComplemento("ATUALIZAR COMPLEMENTO");
		e1.setId_endereco(0); //ID que está sendo mudado (PK)
		eDao.update(e1);
				
				
		//Deletar endereço pelo numero de ID
		eDao.deleteByID(0);//ID que desja excluir
				
				
		//Buscar endereços por ID
		eDao.buscarEnderecoPorId(0);
				
		//Listar todos os endereços cadastrados
		List<Endereco> enderecos = eDao.listarTodos();
						
			for (Endereco e : enderecos) {
						System.out.println(e);
							
			}			
		
	}

}
