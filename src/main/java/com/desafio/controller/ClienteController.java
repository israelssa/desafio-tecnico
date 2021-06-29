package com.desafio.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.desafio.dto.ClienteDTO;
import com.desafio.exception.DesafioException;
import com.desafio.model.Cliente;
import com.desafio.service.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8286556881123576023L;
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
		try {
			return service.findById(id)
		            .map(obj -> new ResponseEntity<>(service.convertToDto(obj), HttpStatus.OK))
		            .orElse(ResponseEntity.notFound().build());
		}catch(DesafioException ex) {
			throw new DesafioException(ex.getMessage());
		}	
    }
	
	@PostMapping("/buscar")
    public ResponseEntity<Page<Cliente>> BuscarPage(@RequestBody ClienteDTO dto) {
		try {
			return new ResponseEntity<>(service.findByClausureAndPage(dto),HttpStatus.OK);
		}catch(DesafioException ex) {
			throw new DesafioException(ex.getMessage());
		}	
    }
	
	@PostMapping
	public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO dto){
		try {
			return new ResponseEntity<>(service.convertToDto(service.salvar(service.convertToEntity(dto))), HttpStatus.OK);
		}catch(DesafioException ex) {
			throw new DesafioException(ex.getMessage());
		}	
	}
	
	@PutMapping
	public ResponseEntity<ClienteDTO> atualizar(@RequestBody ClienteDTO dto){
		try {
			return new ResponseEntity<>(service.convertToDto(service.salvar(service.convertToEntity(dto))), HttpStatus.OK);
		}catch(DesafioException ex) {
			throw new DesafioException(ex.getMessage());
		}	
	}
	
	@DeleteMapping
	public ResponseEntity<ClienteDTO> delete(@RequestBody ClienteDTO dto) {
		try {
			service.deleteById(dto.getId());
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}catch (Exception ex) {
			throw new DesafioException(ex.getMessage());
		}
	}

}
