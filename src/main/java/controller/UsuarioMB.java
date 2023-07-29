package controller;

import java.util.UUID;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import model.UsuarioBean;
import model.entities.Usuario;

@RequestScoped
@Named
public class UsuarioMB {

	@EJB
	private UsuarioBean usuarioBean;

	private String codigo;
	private String nome;
	private String cpf;
	private String senha;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void inserirUsuario() throws Exception {
		
		Usuario usuario = new Usuario();

		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setSenha(senha);
		
		usuarioBean.inserir(usuario);
		
	}
	
	public void alterarUsuario() throws Exception {
		
		Usuario usuario = new Usuario();
		
		UUID codigoUUID = UUID.fromString(codigo);

		usuario.setCodigo(codigoUUID);
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setSenha(senha);
		
		usuarioBean.alterar(usuario);
		
	}
	
	public void lerUsuario() throws Exception {
		
		Usuario usuario = usuarioBean.ler(codigo);
		
		codigo = usuario.getCodigo().toString();
		nome = usuario.getNome();
		cpf = usuario.getCpf();
		senha = usuario.getSenha();
		
	}
	
	public void deletarUsuario() throws Exception {
		
		usuarioBean.deletar(codigo);
		
	}

}
