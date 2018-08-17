package com.example.democom.felipe.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.democom.felipe.cursomc.domain.Categoria;
import com.example.democom.felipe.cursomc.services.CategoriaServices;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaServices service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //salvar é POST, deletar DELET, etc...
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
//				LISTA DEIXOU DE EXISTIR, AGORA É O find() .. Esse metodo abaixo foi mostrado pelo professor
//		Categoria cat1 = new Categoria(1, "informatica");
//		Categoria cat2 = new Categoria(2, "escritório");
//		
//		List<Categoria> lista = new ArrayList<>();
//		
//		lista.add(cat1);
//		lista.add(cat2);
//		
//		return lista;
	}
	
}
