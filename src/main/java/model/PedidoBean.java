package model;

import java.util.UUID;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import model.entities.Pedido;
import model.repositories.PedidoRepositories;
import teste.repositories.Fachada;

@Stateless
public class PedidoBean {
	
	@EJB
	PedidoRepositories pedidoRepositories;
	
	public boolean inserir(Pedido novoPedido) throws Exception {
		boolean inserido = false;
		if(novoPedido.getData() != null	&& novoPedido.getStatus().length() == 1 
				&& novoPedido.getStatus() == "a" && novoPedido.getItens().size() != 0) {
			if(pedidoRepositories == null) {
				Fachada.getCurrentInstance().inserir(novoPedido);
			}else {
				pedidoRepositories.inserir(novoPedido);
			}
			inserido = true;
		}
		return inserido;
	}
	
	public boolean alterar(Pedido pedidoAtual) throws Exception {
		boolean alterado = false;
		if(pedidoAtual.getData() != null	&& pedidoAtual.getStatus().length() == 1 
				&& pedidoAtual.getItens().size() != 0 && pedidoAtual.getCodigo() != null) {
			if(pedidoRepositories == null) {
				Fachada.getCurrentInstance().alterar(pedidoAtual);
			}else {
				pedidoRepositories.alterar(pedidoAtual);
			}
			alterado = true;
		}
		return alterado;
	}
	
	public Pedido ler(String codigo) throws Exception {
		Pedido pedido = null;
		if(codigo != "") {
			UUID codigoUUID = UUID.fromString(codigo);
			if(pedidoRepositories == null) {
				pedido = Fachada.getCurrentInstance().lerPedido(codigoUUID);
			}else {
				pedido = pedidoRepositories.ler(codigoUUID);
			}
		}
		return pedido;
	}
	
	public boolean deletar(String codigo) throws Exception {
		boolean deletado = false;
		if(codigo != "") {
			UUID codigoUUID = UUID.fromString(codigo);
			if(pedidoRepositories == null) {
				Fachada.getCurrentInstance().deletarPedido(codigoUUID);
			}else {
				pedidoRepositories.deletar(codigoUUID);
			}
			deletado = true;
		}
		return deletado;
	}

}
