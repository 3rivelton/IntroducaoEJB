package teste.repositories;

import java.util.UUID;

import model.entities.Item;
import model.entities.Pedido;
import model.entities.Usuario;

public class Fachada {

	private static Fachada myself = null;

	private Repositories<Usuario, UUID> rUsuario = null;
	private Repositories<Pedido, UUID> rPedido = null;
	private Repositories<Item, UUID> rItem = null;

	private Fachada() {

		this.rUsuario = new UsuarioRepositories();
		this.rPedido = new PedidoRepositories();
		this.rItem = new ItemRepositories();

	}

	public static Fachada getCurrentInstance() {

		if (myself == null)
			myself = new Fachada();

		return myself;

	}

	//Usuario
	public void inserir(Usuario usuario) throws Exception {
		this.rUsuario.inserir(usuario);
	}

	public void alterar(Usuario usuario) throws Exception {
		this.rUsuario.alterar(usuario);
	}

	public Usuario lerUsuario(UUID codigo) throws Exception {
		return this.rUsuario.ler(codigo);
	}

	public void deletarUsuario(UUID codigo) throws Exception {
		this.rUsuario.deletar(codigo);
	}
	
	public void limparUsuarios() throws Exception {
		this.rUsuario.limparLista();
	}
	
	//Pedido
	public void inserir(Pedido pedido) throws Exception {
		this.rPedido.inserir(pedido);
	}
	
	public void alterar(Pedido pedido) throws Exception {
		this.rPedido.alterar(pedido);
	}
	
	public Pedido lerPedido(UUID codigo) throws Exception {
		return this.rPedido.ler(codigo);
	}
	
	public void deletarPedido(UUID codigo) throws Exception {
		this.rPedido.deletar(codigo);
	}
	
	public void limparPedidos() throws Exception {
		this.rPedido.limparLista();
	}
	
	//Item
	public void inserir(Item item) throws Exception {
		this.rItem.inserir(item);
	}
	
	public void alterar(Item item) throws Exception {
		this.rItem.alterar(item);
	}
	
	public Item lerItem(UUID codigo) throws Exception {
		return this.rItem.ler(codigo);
	}
	
	public void deletarItem(UUID codigo) throws Exception {
		this.rItem.deletar(codigo);
	}
	
	public void limparItens() throws Exception {
		this.rItem.limparLista();
	}
}
