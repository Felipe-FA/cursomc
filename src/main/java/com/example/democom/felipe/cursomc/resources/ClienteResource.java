package com.example.democom.felipe.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.democom.felipe.cursomc.domain.Cliente;
import com.example.democom.felipe.cursomc.services.ClienteServices;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteServices service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //salvar é POST, deletar DELET, etc...
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	
	}
}
