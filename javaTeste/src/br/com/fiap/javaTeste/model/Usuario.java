package br.com.fiap.javaTeste.model;

import java.util.Date;

public class Usuario {

	private int id_usuario;
	private String nome;
	private String senha;
	private String email;
	private Date dt_nascimento;

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date date) {
		this.dt_nascimento = date;
	}

	@Override
	public String toString() {
		return "Id -> " + id_usuario + " Nome -> " + nome + " Senha -> " + senha + " E-mail -> " + email
				+ " Data de Nascimento -> " + dt_nascimento;
	}

}
