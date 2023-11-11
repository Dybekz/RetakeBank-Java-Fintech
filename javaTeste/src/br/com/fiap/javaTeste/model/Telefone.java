package br.com.fiap.javaTeste.model;

public class Telefone {

	private int id_telefone;
	private String nr_telefone;

	public int getId_telefone() {
		return id_telefone;
	}

	public void setId_telefone(int id_telefone) {
		this.id_telefone = id_telefone;
	}

	public String getNr_telefone() {
		return nr_telefone;
	}

	public void setNr_telefone(String nr_telefone) {
		this.nr_telefone = nr_telefone;

	
	}

	
	@Override
	public String toString() {
		return "Id -> " + id_telefone + " Número de Telefone -> " + nr_telefone ;
	}

}
