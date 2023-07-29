package model.repositories;

import java.util.UUID;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.entities.Pedido;

@Singleton
public class PedidoRepositories {

	@PersistenceContext(name = "descorp")
	private EntityManager entityManager;

	public void inserir(Pedido pedido) throws Exception {

		this.entityManager.persist(pedido);
		this.entityManager.flush();
	}

	public void alterar(Pedido pedido) throws Exception {

		this.entityManager.merge(pedido);
		this.entityManager.flush();
	}

	public Pedido ler(UUID codigo) throws Exception {

		Pedido pedido = null;
		pedido = entityManager.find(Pedido.class, codigo);
		return pedido;
	}

	public void deletar(UUID codigo) throws Exception {

		Pedido pedido = null;
		pedido = entityManager.find(Pedido.class, codigo);
		entityManager.remove(pedido);
	}
}
