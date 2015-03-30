package com.unisinos.devweb.backend;

public class Texto {
	
	private int id;
	private String conteudo;
	
	public Texto(int id, String conteudo) {
		this.id = id;
		this.conteudo = conteudo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String toString() {
		return id + "; " + conteudo;
	}
}
