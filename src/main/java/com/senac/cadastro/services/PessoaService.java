package com.senac.cadastro.services;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.cadastro.entities.Pessoa;
import com.senac.cadastro.repositories.PessoaRepository;

@Service
public class PessoaService {

	private PessoaRepository pessoaRepository;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	public List<Pessoa>listarPessoas(){
		return pessoaRepository.findAll();
	}
	
	public Pessoa adicionarPessoa(Pessoa pessoa) {
		rabbitTemplate.convertAndSend("fila-cadastro", pessoa);
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa atualizarPessoa(int id,Pessoa pessoa) {
		if (pessoaRepository.existsById(id)) {
			return pessoaRepository.save(pessoa);
		}else {
			return null;
		}
	}
	
	@RabbitListener(queues = "fila-cadastro")
	private void subscribe (Pessoa pessoa) {
		System.out.println(pessoa.getNome());
	}
}
