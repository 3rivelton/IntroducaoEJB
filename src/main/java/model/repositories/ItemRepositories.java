package model.repositories;

import java.util.UUID;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.entities.Item;

@Singleton
public class ItemRepositories {

	@PersistenceContext(name = "descorp")
	private EntityManager entityManager;

	public void inserir(Item item) throws Exception {

		this.entityManager.persist(item);
		this.entityManager.flush();
	}

	public void alterar(Item item) throws Exception {

		this.entityManager.merge(item);
		this.entityManager.flush();
	}

	public Item ler(UUID codigo) throws Exception {

		Item item = null;
		item = entityManager.find(Item.class, codigo);
		return item;
	}

	public void deletar(UUID codigo) throws Exception {

		Item item = null;
		item = entityManager.find(Item.class, codigo);
		entityManager.remove(item);
	}
}
