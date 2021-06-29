package com.desafio.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.desafio.dao.ClienteDAO;
import com.desafio.dto.ClienteDTO;
import com.desafio.model.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
    private ModelMapper modelMapper;
	
	public Optional<Cliente> findById(Integer id){
		return clienteDAO.findById(id);
	}
	
	public Cliente salvar(Cliente cliente){
		return clienteDAO.save(cliente);
	}
	
	public List<ClienteDTO> findAll() {
		Iterable<Cliente> list = clienteDAO.findAll();
		return IterableUtils.toList(list).stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	public Page<Cliente> findByClausureAndPage(ClienteDTO cliente){
		
		Pageable pageRequest;
		
		if(cliente.getPage().getSortOrderAsc()) {
			pageRequest = PageRequest.of(cliente.getPage().getPageNumber(), cliente.getPage().getPageSize(), Sort.by(cliente.getPage().getSortField()));
		}else {
			pageRequest = PageRequest.of(cliente.getPage().getPageNumber(), cliente.getPage().getPageSize(), Sort.by(cliente.getPage().getSortField()).descending());
		}
		
		return clienteDAO.findByNomeContaining(cliente.getNome(), pageRequest);
		
	}
	
	public ClienteDTO convertToDto(Cliente cliente) {
		return modelMapper.map(cliente, ClienteDTO.class);	
	}
	
	public Cliente convertToEntity(ClienteDTO dto) {
		return modelMapper.map(dto, Cliente.class);
	}
	
	
	public void deleteById(Integer id) {
		clienteDAO.deleteById(id);
	}
}
