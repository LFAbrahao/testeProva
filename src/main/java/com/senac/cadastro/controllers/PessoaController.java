package com.senac.cadastro.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.cadastro.entities.Pessoa;
import com.senac.cadastro.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	private PessoaService pessoaService;
	
	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@GetMapping(value="listarPessoas")
	public ResponseEntity<List<Pessoa>> ListarPessoas(){
		List<Pessoa> pessoas = pessoaService.listarPessoas();
		return ResponseEntity.ok(pessoas);
	}
	
	@PostMapping(value="adicionarPessoa")
	public ResponseEntity<Pessoa> AdicionarPessoa(@RequestBody Pessoa pessoa){
		Pessoa tempPessoa = pessoaService.adicionarPessoa(pessoa);
		return ResponseEntity.ok(tempPessoa);
	}
}
