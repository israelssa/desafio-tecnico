package com.desafio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.desafio.model.Cliente;
import com.desafio.service.ClienteService;


@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private ClienteService clienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Override
    public void run(String... args) throws Exception {
		
		for(int i = 1; i <= 100; i++) {
			Cliente cliente = new Cliente("Cliente ".concat(String.valueOf(i)), i);
			clienteService.salvar(cliente);
		}
		
    }

}
