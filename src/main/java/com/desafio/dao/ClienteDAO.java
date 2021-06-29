package com.desafio.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.desafio.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer>, QueryByExampleExecutor<Cliente> {
	Page<Cliente> findByNomeContaining(String nome, Pageable pageable);
}



