package br.com.fiap.javaTeste.model;

public class Lembrete {

	private int id_lembrete;
	private String gas;
	private String luz;
	private String internet;
	private String agua;
	private String faculdade;

	public int getId_lembrete() {
		return id_lembrete;
	}

	public void setId_lembrete(int id_lembrete) {
		this.id_lembrete = id_lembrete;
	}

	public String getGas() {
		return gas;
	}

	public void setGas(String gas) {
		this.gas = gas;
	}

	public String getLuz() {
		return luz;
	}

	public void setLuz(String luz) {
		this.luz = luz;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public String getAgua() {
		return agua;
	}

	public void setAgua(String agua) {
		this.agua = agua;
	}

	public String getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(String faculdade) {
		this.faculdade = faculdade;
	}

	@Override
	public String toString() {
		return "Id -> " + id_lembrete + " Gás -> " + gas + " Luz -> " + luz + "Internet -> " + internet + "Água -> " + faculdade ;
	}


}
