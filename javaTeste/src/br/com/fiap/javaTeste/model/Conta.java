package br.com.fiap.javaTeste.model;

public class Conta {

	private int id_conta;
	private String nome;
	private double saldo;

	public int getId_conta() {
		return id_conta;
	}

	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double d) {
		this.saldo = d;
	}

	@Override
	public String toString() {
		return "Id -> " + id_conta + " Nome -> " + nome + " Saldo -> " + saldo ;
	}

	public void setSaldo(String string) {
		
	}

}
