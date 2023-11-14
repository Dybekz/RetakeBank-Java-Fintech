package br.com.fiap.javaTeste.model;

public class Cep {

	private int id_cep;
	private String nr_cep;

	public int getId_cep() {
		return id_cep;
	}

	public void setId_cep(int id_cep) {
		this.id_cep = id_cep;
	}

	public String getNr_cep() {
		return nr_cep;
	}

	public void setNr_cep(String nr_cep) {
		this.nr_cep = nr_cep;
	}

	@Override
	public String toString() {
		return "Id -> " + id_cep + " CEP -> " + nr_cep ;
	}

}
