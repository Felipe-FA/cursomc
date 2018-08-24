package com.example.democom.felipe.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.democom.felipe.cursomc.domain.Cliente;
import com.example.democom.felipe.cursomc.repositories.ClienteRepository;
import com.example.democom.felipe.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteServices {
	
	@Autowired
	public ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id
					+ ", tipo: " + Cliente.class.getName()));
	}	
}
