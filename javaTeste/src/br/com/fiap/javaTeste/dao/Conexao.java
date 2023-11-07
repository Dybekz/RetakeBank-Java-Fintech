package br.com.fiap.javaTeste.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	private static final String USUARIO = "RM97961";
	private static final String SENHA = "040902";

	public static Connection abrirConexao() {
		
		Connection conexao = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
			System.out.println("Sucesso");
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada!");
		} catch (SQLException e) {
			System.out.println("Erro de conexão!");
		}
		
		return conexao;
	}

		
}
