package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;
import org.junit.Test;
import model.ItemBean;
import model.entities.Item;
import teste.repositories.Fachada;

public class ItemTeste {
	
	String codigo = "fbe516f6-3e39-11eb-b897-0862660ccbd4";
	UUID codigoUUID = UUID.fromString(codigo);
	
	@Test
	public void inserirItemCorreto() throws Exception {
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		assertTrue(itemBean.inserir(item));
		
		Fachada.getCurrentInstance().limparItens();
	}
	
	@Test
	public void inserirItemSemDescricao() throws Exception {
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		item.setCodigo(codigoUUID);
		item.setDescricao("");
		item.setUnidade("kg");
		
		assertFalse(itemBean.inserir(item));
	}
	
	@Test
	public void inserirItemSemUnidade() throws Exception{
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("");
		
		assertFalse(itemBean.inserir(item));
	}
	
	@Test
	public void inserirItemDescricaoErrada() throws Exception{
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		item.setCodigo(codigoUUID);
		item.setDescricao("Arrozdahadfhdgnhsdgnsdgnsfdghsd");
		item.setUnidade("kg");
		
		assertFalse(itemBean.inserir(item));
	}
	
	@Test
	public void inserirItemUnidadeErrada() throws Exception{
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("uma tuia e um bocado");
		
		assertFalse(itemBean.inserir(item));
	}
	
	@Test
	public void alterarItemCorreto() throws Exception{
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		itemBean.inserir(item);
		
		item.setDescricao("feijão");
		
		assertTrue(itemBean.alterar(item));
		
	}
	
	@Test
	public void alterarItemSemDescricao() throws Exception {
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		item.setCodigo(codigoUUID);
		item.setDescricao("");
		item.setUnidade("kg");
		
		assertFalse(itemBean.alterar(item));
		
	}
	
	@Test
	public void alterarItemSemUnidade() throws Exception{
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("");
		
		assertFalse(itemBean.alterar(item));
		
	}
	
	@Test
	public void alterarItemDescricaoErrada() throws Exception{
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		item.setCodigo(codigoUUID);
		item.setDescricao("Arrozdahadfhdgnhsdgnsdgnsfdghsd");
		item.setUnidade("kg");
		
		assertFalse(itemBean.alterar(item));
		
	}
	
	@Test
	public void alterarItemUnidadeErrada() throws Exception{
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("uma tuia e um bocado");
		
		assertFalse(itemBean.alterar(item));
		
	}
	
	@Test
	public void lerItemCorreto() throws Exception{
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		itemBean.inserir(item);
		
		item = itemBean.ler(codigo);

		assertNotNull(item);
		
		Fachada.getCurrentInstance().limparItens();
	}
	
	@Test
	public void lerItemIncorreto() throws Exception{
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		itemBean.inserir(item);
		
		String codigoErrado = "fbe517f7-3e39-11eb-b897-0862660ccbd4";

		assertNull(itemBean.ler(codigoErrado));
		
		Fachada.getCurrentInstance().limparItens();
	}
	
	@Test
	public void deletarItemCorreto() throws Exception {
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		itemBean.inserir(item);
		
		itemBean.deletar(codigo);
		
		assertNull(itemBean.ler(codigo));
		
		Fachada.getCurrentInstance().limparItens();
	}

	@Test
	public void deletarItemIncorreto() throws Exception {
		
		ItemBean itemBean = new ItemBean();
		
		Item item = new Item();
		
		item.setCodigo(codigoUUID);
		item.setDescricao("Arroz");
		item.setUnidade("kg");
		
		itemBean.inserir(item);
		
		String codigoErrado = "fbe517f7-3e39-11eb-b897-0862660ccbd4";
		
		itemBean.deletar(codigoErrado);
		
		assertNotNull(itemBean.ler(codigo));
		
		Fachada.getCurrentInstance().limparItens();
	}
}
