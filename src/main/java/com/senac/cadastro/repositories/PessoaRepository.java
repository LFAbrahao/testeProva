package com.senac.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senac.cadastro.entities.Pessoa;

import jakarta.transaction.Transactional;


@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Integer>{

	@Transactional
	@Query(value = "UPDATE pessoa SET pessoa_status = -1 WHERE pessoa_id = :id", nativeQuery = true)
	void apagarLogicoPessoaPorID(@Param("id") Integer id);
}
