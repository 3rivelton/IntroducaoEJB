package teste.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.entities.Pedido;

public class PedidoRepositories implements Repositories<Pedido, UUID> {

	private static PedidoRepositories myself = null;

	public static PedidoRepositories getCurrentInstance() {
		if (myself == null) {
			myself = new PedidoRepositories();
		}
		return myself;
	}

	public PedidoRepositories(){}
	List<Pedido> pedidos = new ArrayList<>();
	@Override
	public void inserir(Pedido pedido) throws Exception {
		this.pedidos.add(pedido);
	}

	@Override
	public void alterar(Pedido pedido) throws Exception {
		
		for (Pedido pedidoAux : pedidos) {
			if (pedidoAux.getCodigo().equals(pedido.getCodigo())) {
				pedidoAux.setData(pedido.getData());
				pedidoAux.setStatus(pedido.getStatus());
				pedidoAux.setItens(pedido.getItens());
				return;
			}
		}
	}

	@Override
	public Pedido ler(UUID codigo) throws Exception {
		for (Pedido pedido : pedidos) {
			if (pedido.getCodigo().equals(codigo)) {
				return pedido;
			}
		}
		return null;
	}

	@Override
	public void deletar(UUID codigo) throws Exception {
		Pedido pedidoDeletado = null;
		for (Pedido pedido : pedidos) {
			if (pedido.getCodigo().equals(codigo)) {
				pedidoDeletado = pedido;
				break;
			}
		}
		pedidos.remove(pedidoDeletado);
	}
	
	@Override
	public void limparLista() {
		pedidos.clear();
	}
}
