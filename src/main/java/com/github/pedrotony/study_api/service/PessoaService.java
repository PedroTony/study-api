package com.github.pedrotony.study_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pedrotony.study_api.model.Pessoa;

@Service
public class PessoaService {
	private List<Pessoa> pessoas;
	
	public PessoaService() {
		load();
	}

	private void load() {
		pessoas = new ArrayList<>();
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Pedro");
		pessoas.add(pessoa);
		
		pessoa = new Pessoa();
		pessoa.setId(2L);
		pessoa.setNome("Henrique");
		pessoas.add(pessoa);
		
		pessoa = new Pessoa();
		pessoa.setId(3L);
		pessoa.setNome("Tony");
		pessoas.add(pessoa);
		
	}
	
	public List<Pessoa> getList(){
		return pessoas;
	}
	
}
