package com.example.democom.felipe.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.democom.felipe.cursomc.domain.Categoria;
import com.example.democom.felipe.cursomc.domain.Cidade;
import com.example.democom.felipe.cursomc.domain.Estado;
import com.example.democom.felipe.cursomc.domain.Produto;
import com.example.democom.felipe.cursomc.repositories.CategoriaRepository;
import com.example.democom.felipe.cursomc.repositories.CidadeRepository;
import com.example.democom.felipe.cursomc.repositories.EstadoRepository;
import com.example.democom.felipe.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritório");

		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	    categoriaRepository.flush();
	    produtoRepository.flush();
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1,cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
//		
//		Estado est1 = new Estado(null, "Minas Gerais");
//		Estado est2 = new Estado(null, "São Paulo");
//		
//		Cidade c1 = new Cidade(null, "Uberlândia", est1);
//		Cidade c2 = new Cidade(null, "São Paulo", est2);
//		Cidade c3 = new Cidade(null, "Campinas", est2);
//		
//		estadoRepository.saveAll(Arrays.asList(est1, est2));
//		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
//		estadoRepository.flush();
//		cidadeRepository.flush();
//		
//		est1.getCidades().addAll(Arrays.asList(c1));
//		est2.getCidades().addAll(Arrays.asList(c2, c3));
// 		estadoRepository.saveAll(Arrays.asList(est1, est2));
//		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
	}
}
