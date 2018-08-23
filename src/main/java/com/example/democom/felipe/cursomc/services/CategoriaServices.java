package com.example.democom.felipe.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.democom.felipe.cursomc.domain.Categoria;
import com.example.democom.felipe.cursomc.repositories.CategoriaRepository;
import com.example.democom.felipe.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaServices {
	
	@Autowired
	public CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id
					+ ", tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
