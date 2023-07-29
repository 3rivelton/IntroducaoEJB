package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import model.PedidoBean;
import model.entities.Item;
import model.entities.Pedido;

@RequestScoped
@Named
public class PedidosMB {
	
	@EJB
	private PedidoBean pedidoBean;
	
	private String codigo;
	private Date data;
	private String status;
	private List<Item> itens = new ArrayList<>();

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public void inserirPedido() throws Exception {
		
		Pedido pedido = new Pedido();
		
		pedido.setData(data);
		pedido.setStatus(status);
		pedido.setItens(itens);
		
		pedidoBean.inserir(pedido);
		
	}
	
	public void alterarPedido() throws Exception {
		
		Pedido pedido = new Pedido();
		
		UUID codigoUUID = UUID.fromString(codigo);
		
		pedido.setCodigo(codigoUUID);
		pedido.setData(data);
		pedido.setStatus(status);
		pedido.setItens(itens);
		
		pedidoBean.alterar(pedido);
		
	}
	
	public void lerPedido() throws Exception {
		
		pedidoBean.ler(codigo);
		
	}
	
	public void deletarPedido() throws Exception {
		
		pedidoBean.deletar(codigo);
		
	}

}
