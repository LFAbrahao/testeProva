package com.senac.cadastro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senac.cadastro.entities.Pessoa;
import com.senac.cadastro.repositories.PessoaRepository;

@Service
public class PessoaService {

	private PessoaRepository pessoaRepository;
	
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	public List<Pessoa>listarPessoas(){
		return pessoaRepository.findAll();
	}
	
	public Pessoa adicionarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
}
