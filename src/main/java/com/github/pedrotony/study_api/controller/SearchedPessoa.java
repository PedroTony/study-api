package com.github.pedrotony.study_api.controller;

import com.github.pedrotony.study_api.model.Pessoa;

public class SearchedPessoa {
	private long id;
	private String nome;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static SearchedPessoa toDto(Pessoa pessoa) {
		SearchedPessoa dto = new SearchedPessoa();
		dto.setId(pessoa.getId());
		dto.setNome(pessoa.getNome());
		return dto;
	}
}
