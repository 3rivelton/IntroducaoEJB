package controller;

import java.util.UUID;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import model.ItemBean;
import model.entities.Item;

@RequestScoped
@Named
public class ItensMB {
	
	@EJB
	ItemBean itemBean;
	
	private String codigo;
	private String descricao;
	private String unidade;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public void inserirItem() throws Exception {
		
		Item item = new Item();
		
		item.setDescricao(descricao);
		item.setUnidade(unidade);
		
		itemBean.inserir(item);
		
	}
	
	public void alterarItem() throws Exception {
		
		Item item = new Item();
		
		UUID codigoUUID = UUID.fromString(codigo);
		
		item.setCodigo(codigoUUID);
		item.setDescricao(descricao);
		item.setUnidade(unidade);
		
		itemBean.alterar(item);
		
	}
	
	public void lerItem() throws Exception {
		
		Item item = itemBean.ler(codigo);
		
		codigo = item.getCodigo().toString();
		descricao = item.getDescricao();
		unidade = item.getUnidade();
		
	}
	
	public void deletarItem() throws Exception {
		
		itemBean.deletar(codigo);
	}

}