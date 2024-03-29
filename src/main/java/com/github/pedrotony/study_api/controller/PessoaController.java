package com.github.pedrotony.study_api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<SearchedPessoa>> listAll() {
		List<SearchedPessoa> result = pessoaService.list().stream().map(SearchedPessoa::toDto).collect(Collectors.toList());	
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@PostMapping	
	public ResponseEntity<Pessoa>  create(@RequestBody PessoaRequestCreate dto) {
		// DE PARAmapeamento entre dto e o model
		// DEPARA mapeamento entre PessoaCreated e Pessoa
		
		Pessoa pessoa = new Pessoa();
		
		// mapeamento
		pessoa.setIdade(dto.getIdade());
		pessoa.setNome(dto.getNome());		
		
		Pessoa result = pessoaService.save(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@PutMapping
	public ResponseEntity<Pessoa> update(@RequestBody PessoaRequestUpdate dto) {
		// verificar se o id informado já existe
		
		boolean exists =
				pessoaRepository.existsById(dto.getId());
		
		if (!exists) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		Pessoa pessoa = new Pessoa();
		// mapeamento
		pessoa.setId(dto.getId());
		pessoa.setIdade(dto.getIdade());
		pessoa.setNome(dto.getNome());		

		Pessoa result = pessoaService.save(pessoa);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		boolean exists = pessoaRepository.existsById(id);
		if(!exists) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		pessoaRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();	
		
	}

}

