package com.desafio.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1712468753164470819L;
	
	private Integer id;
	private String nome;
	private Integer idade;
	private PageDTO page;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public PageDTO getPage() {
		return page;
	}
	public void setPage(PageDTO page) {
		this.page = page;
	}
	
}

