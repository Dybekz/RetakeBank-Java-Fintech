package br.com.fiap.javaTeste.model;

public class Cartao {

	private int id_cartao;
	private String nm_cartao;
	private String nr_cartao;
	private String vld_cartao;
	private String cvv_cartao;

	public int getId_cartao() {
		return id_cartao;
	}

	public void setId_cartao(int id_cartao) {
		this.id_cartao = id_cartao;
	}

	public String getNm_cartao() {
		return nm_cartao;
	}

	public void setNm_cartao(String nm_cartao) {
		this.nm_cartao = nm_cartao;
	}

	public String getNr_cartao() {
		return nr_cartao;
	}

	public void setNr_cartao(String nr_cartao) {
		this.nr_cartao = nr_cartao;
	}

	public String getVld_cartao() {
		return vld_cartao;
	}

	public void setVld_cartao(String vld_cartao) {
		this.vld_cartao = vld_cartao;
	}

	public String getCvv_cartao() {
		return cvv_cartao;
	}

	public void setCvv_cartao(String cvv_cartao) {
		this.cvv_cartao = cvv_cartao;
	}

	@Override
	public String toString() {
		return "Id -> " + id_cartao + " Nome no Cartão -> " + nm_cartao + " Número do Cartão-> " + nr_cartao + "Validade do Cartão -> " + vld_cartao + "CVV -> " + cvv_cartao ;
	}


}
