package com.example.democom.felipe.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.democom.felipe.cursomc.domain.Categoria;

@Repository
public interface CidadeRepository extends JpaRepository<Categoria, Integer> {

}
