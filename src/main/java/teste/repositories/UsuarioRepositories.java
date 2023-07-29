package teste.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.entities.Usuario;

public class UsuarioRepositories implements Repositories<Usuario, UUID> {
	
	private static UsuarioRepositories myself = null;
	
	public static UsuarioRepositories getCurrentInstance() {
		if(myself == null) {
			myself = new UsuarioRepositories();
		}
		return myself;
	}
	
	public UsuarioRepositories(){}
	
	List<Usuario> usuarios = new ArrayList<>();
	
	@Override
	public void inserir(Usuario usuario) throws Exception {
		usuarios.add(usuario);
	}
	
	@Override
	public void alterar(Usuario usuario) throws Exception {
		for(Usuario usuarioAux: usuarios) {
			if(usuarioAux.getCodigo().equals(usuario.getCodigo())) {
				usuarioAux.setNome(usuario.getNome());
				usuarioAux.setCpf(usuario.getCpf());
				usuarioAux.setSenha(usuario.getSenha());
				return;
			}
		}
	}

	@Override
	public Usuario ler(UUID codigo) throws Exception {
		for(Usuario usuario: usuarios) {
			if(usuario.getCodigo().equals(codigo)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public void deletar(UUID codigo) throws Exception {
		Usuario usuarioDeletado = null;
		for(Usuario usuario: usuarios) {
			if(usuario.getCodigo().equals(codigo)) {
				usuarioDeletado = usuario;
				break;
			}
		}
		usuarios.remove(usuarioDeletado);
	}
	
	@Override
	public void limparLista() {
		usuarios.clear();
	}
}
