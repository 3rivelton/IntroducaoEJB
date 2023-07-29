package model;

import java.util.UUID;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import model.entities.Usuario;
import model.repositories.UsuarioRepositories;
import teste.repositories.Fachada;

@Stateless
public class UsuarioBean {
	
	@EJB
	UsuarioRepositories usuarioRepositories;
	
	public boolean inserir(Usuario usuarioNovo) throws Exception {
		boolean inseriu = false;
		if(usuarioNovo.getNome() != "" && usuarioNovo.getNome().length() <=50
				&& usuarioNovo.getCpf() != "" && usuarioNovo.getCpf().length() == 11
				&& usuarioNovo.getSenha() != "" && usuarioNovo.getSenha().length() >= 6) {
			if(usuarioRepositories == null) {
				Fachada.getCurrentInstance().inserir(usuarioNovo);
			}else {
				usuarioRepositories.inserir(usuarioNovo);
			}
			inseriu = true;
		}
		return inseriu;
	}
	
	public boolean alterar(Usuario usuarioAtual) throws Exception {
		boolean alterado = false;
		if(usuarioAtual.getCodigo() != null && usuarioAtual.getNome() != "" && usuarioAtual.getNome().length() <=50
				&& usuarioAtual.getCpf() != "" && usuarioAtual.getCpf().length() == 11
				&& usuarioAtual.getSenha() != "" && usuarioAtual.getSenha().length() >= 6) {
			if(usuarioRepositories == null) {
				Fachada.getCurrentInstance().inserir(usuarioAtual);
			}else {
				usuarioRepositories.alterar(usuarioAtual);
			}
			alterado = true;
		}
		return alterado;
	}
	
	public Usuario ler(String codigo) throws Exception {
		Usuario usuario = null;
		if(codigo != "") {
			UUID codigoUUID = UUID.fromString(codigo);
			if(usuarioRepositories == null) {
				usuario = Fachada.getCurrentInstance().lerUsuario(codigoUUID);
			}else {
				usuario = usuarioRepositories.ler(codigoUUID);
			}
		}
		return usuario;
	}
	
	public boolean deletar(String codigo) throws Exception {
		boolean deletado = false;
		if(codigo != "") {
			UUID codigoUUID = UUID.fromString(codigo);
			if(usuarioRepositories == null) {
				Fachada.getCurrentInstance().deletarUsuario(codigoUUID);
			}else {
				usuarioRepositories.deletar(codigoUUID);
			}
			deletado = true;
		}
		return deletado;
	}
}
