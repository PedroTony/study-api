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
		// pessoaService.list();		
		return result;
	}

	@PostMapping	
	public Pessoa create(PessoaCreated dto) {
		// DE PARAmapeamento entre dto e o model
		// DEPARA mapeamento entre PessoaCreated e Pessoa
		
		Pessoa pessoa = new Pessoa();
		
		// mapeamento
		pessoa.setIdade(dto.getIdade());
		pessoa.setNome(dto.getNome());		
		
		Pessoa result = pessoaService.save(pessoa);
		return result;
	}

	@PutMapping
	public Pessoa update(PessoaUpdated dto) {
		// verificar se o id informado já existe
		
		boolean exists =
				pessoaRepository.existsById(dto.getId());
		
		if (!exists) {
			throw new RuntimeException("Id não encontrado " 
							+ dto.getId());			
		}
		Pessoa pessoa = new Pessoa();
		// mapeamento
		pessoa.setId(dto.getId());
		pessoa.setIdade(dto.getIdade());
		pessoa.setNome(dto.getNome());		

		Pessoa result = pessoaService.save(pessoa);
		return result;
	}

	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		pessoaRepository.deleteById(id);		
	}

}

