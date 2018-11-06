package com.example.democom.felipe.cursomc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.democom.felipe.cursomc.domain.ItemPedido;
import com.example.democom.felipe.cursomc.domain.PagamentoComBoleto;
import com.example.democom.felipe.cursomc.domain.Pedido;
import com.example.democom.felipe.cursomc.domain.enums.EstadoPagamento;
import com.example.democom.felipe.cursomc.repositories.ItemPedidoRepository;
import com.example.democom.felipe.cursomc.repositories.PagamentoRepository;
import com.example.democom.felipe.cursomc.repositories.PedidoRepository;
import com.example.democom.felipe.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoServices {
	
	@Autowired
	public PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ProdutoServices produtoServices;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id
					+ ", tipo: " + Pedido.class.getName()));
	}	
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoServices.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}
}
