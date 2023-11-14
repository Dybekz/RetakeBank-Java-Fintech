package br.com.fiap.javaTeste.model;

public class Endereco {

	private int id_endereco;
	private String rua;
	private String bairro;
	private String nr_casa;
	private String cidade;
	private String estado;
	private String complemento;

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNr_casa() {
		return nr_casa;
	}

	public void setNr_casa(String nr_casa) {
		this.nr_casa = nr_casa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Id -> " + id_endereco + " Rua -> " + rua + " Bairro -> " + bairro + "Número da casa -> " + nr_casa + "Cidade -> " + cidade + "Estado -> " + estado + "Complemento -> " + complemento ;
	}


}
