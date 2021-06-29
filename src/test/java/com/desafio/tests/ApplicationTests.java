package com.desafio.tests;

import java.util.List;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.dto.ClienteDTO;
import com.desafio.model.Cliente;
import com.desafio.service.ClienteService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTests {

	@Autowired
	private ClienteService contaService;
	
	@Test
	public void InsertEmBDH2() {
		Cliente cliente = new Cliente("Israel Ramos Queiroz", 33);
		cliente = contaService.salvar(cliente);
		Assert.assertTrue("Chave de Cadastro Criada.", Objects.nonNull(cliente.getId()));
	}
	
	@Test
	public void buscaEmBDH2() {
		List<ClienteDTO> cliente = contaService.findAll();
		Assert.assertTrue("Busca Por Id.", !cliente.isEmpty());
	}
	
	@Test
	public void UpdateEmBDH2() {
		Cliente cliente = contaService.findById(1).get();
		cliente.setNome("Israel Atualizado");
		cliente.setIdade(34);
		cliente = contaService.salvar(cliente);
		cliente = contaService.findById(1).get();
		Assert.assertTrue("Atualização de Registro.", cliente.getNome().equals("Israel Atualizado") && cliente.getIdade() == 34);
	}
	
	@Test
	public void DeleteEmBDH2() {
		contaService.deleteById(1);
		Assert.assertTrue("Exclusão de Registro", contaService.findById(1).isEmpty());
	}

}
