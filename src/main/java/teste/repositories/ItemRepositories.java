package teste.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.entities.Item;

public class ItemRepositories implements Repositories<Item, UUID> {

	private static ItemRepositories myself = null;

	public static ItemRepositories getCurrentInstance() {

		if (myself == null) {
			myself = new ItemRepositories();
		}
		return myself;
	}

	public ItemRepositories(){}

	List<Item> itens = new ArrayList<>();

	@Override
	public void inserir(Item item) {
		itens.add(item);
	}

	@Override
	public void alterar(Item item) {
		for (Item itemAux : itens) {
			if (itemAux.getCodigo().equals(item.getCodigo())) {
				itemAux.setDescricao(item.getDescricao());
				itemAux.setUnidade(item.getUnidade());
				return;
			}
		}
	}

	@Override
	public Item ler(UUID codigo) {
		for (Item item : itens) {
			if (item.getCodigo().equals(codigo)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public void deletar(UUID codigo) {
		Item itemDeletado = null;
		for (Item item : itens) {
			if (item.getCodigo().equals(codigo)) {
				itemDeletado = item;
				break;
			}
		}
		itens.remove(itemDeletado);
	}
	
	@Override
	public void limparLista() {
		itens.clear();
	}
}