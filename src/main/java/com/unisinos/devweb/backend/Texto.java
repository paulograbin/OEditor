package com.unisinos.devweb.backend;

public class Texto {
	
	private int idAuthor;
	private int versao;
	private String conteudo;
	
	public Texto(int id, int versao, String conteudo) {
		this.idAuthor = id;
		this.versao = versao;
		this.conteudo = conteudo;
	}
	
	public int getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}
	public int getVersao() {
		return versao;
	}
	public void setVersao(int versao) {
		this.versao = versao;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	@Override
	public String toString() {
		return idAuthor + ";" + versao + ";" + conteudo;
	}
}
