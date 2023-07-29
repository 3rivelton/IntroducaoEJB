package model.repositories;

import java.util.UUID;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.entities.Usuario;

@Singleton
public class UsuarioRepositories {
	
	@PersistenceContext(name = "descorp")
    private EntityManager entityManager;

	public void inserir(Usuario usuario) throws Exception {
		
		this.entityManager.persist(usuario);
		this.entityManager.flush();
	}

	public void alterar(Usuario usuario) throws Exception {
		
		this.entityManager.merge(usuario);
		this.entityManager.flush();
	}

	public Usuario ler(UUID codigo) throws Exception {
		
		Usuario usuario = null;
		usuario =  entityManager.find(Usuario.class, codigo);
		return usuario;
	}

	public void deletar(UUID codigo) throws Exception {
		
		Usuario usuario = null;
		usuario =  entityManager.find(Usuario.class, codigo);
		entityManager.remove(usuario);
	}
}
