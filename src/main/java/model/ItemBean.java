package model;

import java.util.UUID;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import model.entities.Item;
import model.repositories.ItemRepositories;
import teste.repositories.Fachada;

@Stateless
public class ItemBean {
	
	@EJB
	ItemRepositories itemRepositories;

	public boolean inserir(Item itemNovo) throws Exception {
		
		boolean inseriu = false;

		if(itemNovo.getDescricao() != "" && itemNovo.getDescricao().length() <=30 
				&& itemNovo.getUnidade() != "" && itemNovo.getUnidade().length() <=10) {
			if(itemRepositories == null) {
				Fachada.getCurrentInstance().inserir(itemNovo);
			}else {
				itemRepositories.inserir(itemNovo);
			}
			inseriu = true;
		}
		return inseriu;
	}

	public boolean alterar(Item itemAtual) throws Exception {
		
		boolean alterou = false;

		if(itemAtual.getCodigo() != null && itemAtual.getDescricao() != "" 
				&& itemAtual.getDescricao().length() <=30 && itemAtual.getUnidade() != "" 
				&& itemAtual.getUnidade().length() <=10) {
			if(itemRepositories == null) {
				Fachada.getCurrentInstance().alterar(itemAtual);
			}else {
				itemRepositories.alterar(itemAtual);
			}
			alterou = true;
		}
		
		return alterou;
	}

	public Item ler(String codigo) throws Exception {

		Item item = null;
		
		if(!codigo.isBlank()) {
			UUID codigoUUID = UUID.fromString(codigo);
			if(itemRepositories == null) {
				item = Fachada.getCurrentInstance().lerItem(codigoUUID);
			}else {
				item = itemRepositories.ler(codigoUUID);
			}
		}
		
		return item;
	}
	
	public boolean deletar(String codigo) throws Exception {
		
		boolean deletou = false;
		
		if(codigo != "") {
			UUID codigoUUID = UUID.fromString(codigo);
			if(itemRepositories == null) {
				Fachada.getCurrentInstance().deletarItem(codigoUUID);
			}else {
				itemRepositories.deletar(codigoUUID);
			}
			deletou = true;
		}
		
		return deletou;
	}
}
