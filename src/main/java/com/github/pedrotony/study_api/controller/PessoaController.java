package com.github.pedrotony.study_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pedrotony.study_api.model.Pessoa;
import com.github.pedrotony.study_api.repository.PessoaRepository;
import com.github.pedrotony.study_api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<SearchedPessoa> listAll() {
		List<SearchedPessoa> result = null;
		
		return result;
	}
	@PostMapping
	public Pessoa create(PessoaCreated dto) {
		//De para mapeamento entre o dpo e o model
		//de para mapeamento entre pessoaCreate e Pessoa
		Pessoa pessoa = new Pessoa();
		//mapeamento
		pessoa.setNome(dto.getNome());;
		pessoa.setIdade(dto.getIdade());
		return pessoaService.create(pessoa);
	}
	@PutMapping
	public Pessoa update(PessoaUpdated dto) {	
		//verificar se o id já existe
		Pessoa pessoa = new Pessoa();
		//mapeamento
		pessoa.setId(dto.getId());
		pessoa.setNome(dto.getNome());;
		pessoa.setIdade(dto.getIdade());
		return pessoaService.update(pessoa);
	}
	
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable long id) {
		pessoaRepository.deleteById(id);
	}
	
}
