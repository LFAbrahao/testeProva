package com.senac.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.cadastro.entities.Pessoa;

import jakarta.transaction.Transactional;


@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Integer>{

	
}
