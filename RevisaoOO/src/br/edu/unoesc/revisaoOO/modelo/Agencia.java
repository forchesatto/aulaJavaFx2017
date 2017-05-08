package br.edu.unoesc.revisaoOO.modelo;

import java.io.Serializable;

public class Agencia implements Serializable{

	private static final long serialVersionUID = -7078526979609277117L;
	
	private String nome;
	private Integer numero;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return this.nome + " " + this.numero;
	}

}
