package br.com.fiap.javaTeste.model;

import java.util.Date;

public class Transacao {

	private int id_transacao;
	private Date data;
	private double valor;
	private String tipo;
	private String descricao;

	public int getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(int id_transacao) {
		this.id_transacao = id_transacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Id -> " + id_transacao + " Data -> " + data + " Valor da Transação -> " + valor + "Tipo da Transação -> " + tipo + "Descrição" + descricao ;
	}

}
