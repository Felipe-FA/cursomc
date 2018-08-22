package com.example.democom.felipe.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.democom.felipe.cursomc.domain.Pedido;
import com.example.democom.felipe.cursomc.repositories.PedidoRepository;
import com.example.democom.felipe.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoServices {
	
	@Autowired
	public PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id
					+ ", tipo: " + Pedido.class.getName()));
	}	
}
