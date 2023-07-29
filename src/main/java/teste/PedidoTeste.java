package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import model.PedidoBean;
import model.entities.Item;
import model.entities.Pedido;
import teste.repositories.Fachada;

public class PedidoTeste {
	
	String codigo = "fbe516f6-3e39-11eb-b897-0862660ccbd4";
	UUID codigoUUID = UUID.fromString(codigo);
	
	SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void inserirPedidoTest() throws Exception {

		PedidoBean pedidoBean = new PedidoBean();
		
		Pedido pedido = new Pedido();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		Item item2 = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Feijão");
		item.setUnidade("kg");
		
		List<Item> itens = new ArrayList<>();
		
		itens.add(item);
		itens.add(item2);

		pedido.setCodigo(codigoUUID);
		pedido.setData(dataFormatada.parse("25/07/2023"));
		pedido.setStatus("a");
		pedido.setItens(itens);

		assertTrue(pedidoBean.inserir(pedido));
		
		Fachada.getCurrentInstance().limparPedidos();
	}
	
	@Test
	public void inserirPedidoSemStatus() throws Exception {

		PedidoBean pedidoBean = new PedidoBean();
		
		Pedido pedido = new Pedido();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		Item item2 = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Feijão");
		item.setUnidade("kg");
		
		List<Item> itens = new ArrayList<>();
		
		itens.add(item);
		itens.add(item2);

		pedido.setCodigo(codigoUUID);
		pedido.setData(dataFormatada.parse("25/07/2023"));
		pedido.setStatus("");
		pedido.setItens(itens);

		assertFalse(pedidoBean.inserir(pedido));
	}
	
	@Test
	public void inserirPedidoSemItens() throws Exception {

		PedidoBean pedidoBean = new PedidoBean();
		
		Pedido pedido = new Pedido();
		
		List<Item> itens = new ArrayList<>();

		pedido.setCodigo(codigoUUID);
		pedido.setData(dataFormatada.parse("25/07/2023"));
		pedido.setStatus("a");
		pedido.setItens(itens);

		assertFalse(pedidoBean.inserir(pedido));
	}
	
	@Test
	public void inserirPedidoStatusErrado() throws Exception {

		PedidoBean pedidoBean = new PedidoBean();
		
		Pedido pedido = new Pedido();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		Item item2 = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Feijão");
		item.setUnidade("kg");
		
		List<Item> itens = new ArrayList<>();
		
		itens.add(item);
		itens.add(item2);

		pedido.setCodigo(codigoUUID);
		pedido.setData(dataFormatada.parse("25/07/2023"));
		pedido.setStatus("p");
		pedido.setItens(itens);

		assertFalse(pedidoBean.inserir(pedido));
	}

	@Test
	public void alterarPedidoTest() throws Exception {

		PedidoBean pedidoBean = new PedidoBean();
		
		Pedido pedido = new Pedido();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		Item item2 = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Feijão");
		item.setUnidade("kg");
		
		List<Item> itens = new ArrayList<>();
		
		itens.add(item);
		itens.add(item2);

		pedido.setCodigo(codigoUUID);
		pedido.setData(dataFormatada.parse("25/07/2023"));
		pedido.setStatus("a");
		pedido.setItens(itens);

		pedidoBean.inserir(pedido);
		
		pedido.setStatus("p");
		
		assertTrue(pedidoBean.alterar(pedido));
		Fachada.getCurrentInstance().limparPedidos();
	}
	
	@Test
	public void alterarPedidoSemStatus() throws Exception {

		PedidoBean pedidoBean = new PedidoBean();
		
		Pedido pedido = new Pedido();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		Item item2 = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Feijão");
		item.setUnidade("kg");
		
		List<Item> itens = new ArrayList<>();
		
		itens.add(item);
		itens.add(item2);

		pedido.setCodigo(codigoUUID);
		pedido.setData(dataFormatada.parse("25/07/2023"));
		pedido.setStatus("a");
		pedido.setItens(itens);

		pedidoBean.inserir(pedido);
		
		pedido.setStatus("");
		
		assertFalse(pedidoBean.alterar(pedido));
	}
	
	@Test
	public void lerPedidoTest() throws Exception {
		
		PedidoBean pedidoBean = new PedidoBean();
		
		Pedido pedido = new Pedido();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		Item item2 = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Feijão");
		item.setUnidade("kg");
		
		List<Item> itens = new ArrayList<>();
		
		itens.add(item);
		itens.add(item2);

		pedido.setCodigo(codigoUUID);
		pedido.setData(dataFormatada.parse("25/07/2023"));
		pedido.setStatus("a");
		pedido.setItens(itens);

		pedidoBean.inserir(pedido);
		
		assertNotNull(pedidoBean.ler(codigo));
		Fachada.getCurrentInstance().limparPedidos();
	}
	
	@Test
	public void lerPedidoErrado() throws Exception {
		
		PedidoBean pedidoBean = new PedidoBean();
		
		Pedido pedido = new Pedido();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		Item item2 = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Feijão");
		item.setUnidade("kg");
		
		List<Item> itens = new ArrayList<>();
		
		itens.add(item);
		itens.add(item2);

		pedido.setCodigo(codigoUUID);
		pedido.setData(dataFormatada.parse("25/07/2023"));
		pedido.setStatus("a");
		pedido.setItens(itens);

		pedidoBean.inserir(pedido);
		
		String codigoErrado = "fbe517f7-3e39-11eb-b897-0862660ccbd4";
		
		assertNull(pedidoBean.ler(codigoErrado));
		Fachada.getCurrentInstance().limparPedidos();
	}
	
	@Test
	public void deletarPedidoTest() throws Exception {
		
		PedidoBean pedidoBean = new PedidoBean();
		
		Pedido pedido = new Pedido();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		Item item2 = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Feijão");
		item.setUnidade("kg");
		
		List<Item> itens = new ArrayList<>();
		
		itens.add(item);
		itens.add(item2);

		pedido.setCodigo(codigoUUID);
		pedido.setData(dataFormatada.parse("25/07/2023"));
		pedido.setStatus("a");
		pedido.setItens(itens);

		pedidoBean.inserir(pedido);
		
		pedidoBean.deletar(codigo);
		
		assertNull(pedidoBean.ler(codigo));
		Fachada.getCurrentInstance().limparPedidos();
	}
	
	@Test
	public void deletarPedidoErrado() throws Exception {
		
		PedidoBean pedidoBean = new PedidoBean();
		
		Pedido pedido = new Pedido();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		Item item2 = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Feijão");
		item.setUnidade("kg");
		
		List<Item> itens = new ArrayList<>();
		
		itens.add(item);
		itens.add(item2);

		pedido.setCodigo(codigoUUID);
		pedido.setData(dataFormatada.parse("25/07/2023"));
		pedido.setStatus("a");
		pedido.setItens(itens);

		pedidoBean.inserir(pedido);
		
		String codigoErrado = "fbe517f7-3e39-11eb-b897-0862660ccbd4";
		
		pedidoBean.deletar(codigoErrado);
		
		assertNotNull(pedidoBean.ler(codigo));
		Fachada.getCurrentInstance().limparPedidos();
	}
}
