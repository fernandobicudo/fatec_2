package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.sce.model.Usuario;

public class UC05CadastrarUsuario {
	
	/**
	* Objetivo - verificar o comportamento da aplicacao na inclusao de usuario com dados validos.
	**/
	
	@Test
	public void CT01CadastrarUsuarioComDadosValidos() {
		try {
			// cenario
			Usuario usuario = new Usuario();
			// acao
			usuario = ObtemUsuario.comDadosValidos();
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}

	/**
	* Objetivo - verificar o comportamento da aplicacao na inclusao de usuario com RA em branco.
	**/
	
	@Test
	public void CT02CadastrarUsuarioComRaEmBranco() {
		// cenario
		Usuario usuario = new Usuario();

		try {

			// acao
			usuario = ObtemUsuario.comRAInvalido_branco();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA invalido", e.getMessage());
		}
	}

	/**
	* Objetivo - verificar o comportamento da aplicacao na inclusao de usuario com RA nulo.
	**/
	
	@Test
	public void CT03CadastrarUsuarioComRaNulo() {
		// cenario
		Usuario usuario = new Usuario();
		

		try {

			// acao
			usuario = ObtemUsuario.comRAInvalido_nulo();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA invalido", e.getMessage());
		}
	}

	/**
	* Objetivo - verificar o comportamento da aplicacao na inclusao de usuario com nome em branco.
	**/
	
	@Test
	public void CT04CadastrarUsuarioComNomeEmBranco() {
		// cenario
		Usuario usuario = new Usuario();
		

		try {
			// acao
			usuario = ObtemUsuario.comNomeEmBranco();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome invalido", e.getMessage());
		}
	}

	/**
	* Objetivo - verificar o comportamento da aplicacao na inclusao de usuario com nome nulo.
	**/

	@Test
	public void CT05CadastrarUsuarioComNomeNulo() {
		// cenario
		Usuario usuario = new Usuario();
		
		try {
			// acao
			usuario = ObtemUsuario.comNomeNulo();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome invalido", e.getMessage());
		}
	}
	
	/**

	@Test
	public void CT06CadastrarUsuario_com_sucesso() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setRa("123");
		usuario.setNome("Luis Fernando");
		assertEquals("Luis Fernando", usuario.getNome());
	}

	@Test
	public void CT07CadastrarUsuario_com_sucesso() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setRa("123");
		usuario.setNome("Luis Fernando");
		assertEquals("123", usuario.getRa());
	}
	 **/
}
