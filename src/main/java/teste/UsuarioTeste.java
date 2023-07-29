package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import model.UsuarioBean;
import model.entities.Usuario;
import teste.repositories.Fachada;

public class UsuarioTeste {

	String codigo = "fbe516f6-3e39-11eb-b897-0862660ccbd4";
	UUID codigoUUID = UUID.fromString(codigo);

	@Test
	public void inserirUsuarioTest() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("11111111111");
		usuario.setSenha("123456");

		assertTrue(usuarioBean.inserir(usuario));
		
		Fachada.getCurrentInstance().limparUsuarios();
	}
	
	@Test
	public void inserirUsuarioSemNome() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("");
		usuario.setCpf("11111111111");
		usuario.setSenha("123456");

		assertFalse(usuarioBean.inserir(usuario));
	}
	
	@Test
	public void inserirUsuarioSemCPF() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("");
		usuario.setSenha("123456");

		assertFalse(usuarioBean.inserir(usuario));
	}
	
	@Test
	public void inserirUsuarioSemSenha() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("11111111111");
		usuario.setSenha("");

		assertFalse(usuarioBean.inserir(usuario));
	}
	
	@Test
	public void inserirUsuarioNomeErrado() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alvessssssssssssssssssss");
		usuario.setCpf("11111111111");
		usuario.setSenha("123456");

		assertFalse(usuarioBean.inserir(usuario));
	}
	
	@Test
	public void inserirUsuarioCpfErrado() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("111111111111");
		usuario.setSenha("123456");

		assertFalse(usuarioBean.inserir(usuario));
	}
	
	@Test
	public void inserirUsuarioSenhaErrada() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("11111111111");
		usuario.setSenha("12345");

		assertFalse(usuarioBean.inserir(usuario));
	}

	@Test
	public void alterarUsuarioTest() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("11111111111");
		usuario.setSenha("123456");
		
		usuarioBean.inserir(usuario);
		
		usuario.setSenha("654321");
		
		assertTrue(usuarioBean.alterar(usuario));
		
		Fachada.getCurrentInstance().limparUsuarios();

	}
	
	@Test
	public void alterarUsuarioSemNome() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("");
		usuario.setCpf("11111111111");
		usuario.setSenha("123456");
		
		assertFalse(usuarioBean.alterar(usuario));

	}

	@Test
	public void alterarUsuarioSemCpf() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("");
		usuario.setSenha("123456");
		
		assertFalse(usuarioBean.alterar(usuario));

	}
	
	@Test
	public void alterarUsuarioSemSenha() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("11111111111");
		usuario.setSenha("");
		
		assertFalse(usuarioBean.alterar(usuario));

	}
	
	@Test
	public void alterarUsuarioNomeErrado() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alvessssssssssssssssssss");
		usuario.setCpf("11111111111");
		usuario.setSenha("123456");
		
		assertFalse(usuarioBean.alterar(usuario));

	}
	
	@Test
	public void alterarUsuarioCpfErrado() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("111111111111");
		usuario.setSenha("123456");
		
		assertFalse(usuarioBean.alterar(usuario));

	}
	
	@Test
	public void alterarUsuarioSenhaErrada() throws Exception {

		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("11111111111");
		usuario.setSenha("12345");
		
		assertFalse(usuarioBean.alterar(usuario));

	}
	
	@Test
	public void lerUsuarioTest() throws Exception {
		
		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("11111111111");
		usuario.setSenha("123456");

		usuarioBean.inserir(usuario);
		
		assertNotNull(usuarioBean.ler(codigo));
		
		Fachada.getCurrentInstance().limparUsuarios();
		
	}
	
	@Test
	public void lerUsuarioErrado() throws Exception {
		
		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("11111111111");
		usuario.setSenha("123456");

		usuarioBean.inserir(usuario);
		
		String codigoErrado = "fbe517f7-3e39-11eb-b897-0862660ccbd4";
		
		assertNull(usuarioBean.ler(codigoErrado));
		
		Fachada.getCurrentInstance().limparUsuarios();
		
	}
	
	@Test
	public void deletarUsuarioTest() throws Exception {
		
		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("11111111111");
		usuario.setSenha("123456");

		usuarioBean.inserir(usuario);
		
		usuarioBean.deletar(codigo);
		
		assertNull(usuarioBean.ler(codigo));
		
		Fachada.getCurrentInstance().limparUsuarios();
	}
	
	@Test
	public void deletarUsuarioErrado() throws Exception {
		
		UsuarioBean usuarioBean = new UsuarioBean();
		
		Usuario usuario = new Usuario();

		usuario.setCodigo(codigoUUID);
		usuario.setNome("Erivelton Ribeiro da Silva Alves");
		usuario.setCpf("11111111111");
		usuario.setSenha("123456");

		usuarioBean.inserir(usuario);
		
		String codigoErrado = "fbe517f7-3e39-11eb-b897-0862660ccbd4";
		
		usuarioBean.deletar(codigoErrado);
		
		assertNotNull(usuarioBean.ler(codigo));
		
		Fachada.getCurrentInstance().limparUsuarios();
	}
}
