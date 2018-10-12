package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;

public class UC05CadastrarUsuario {

	@Test
	public void CT01CadastrarUsuarioComDadosValidos() {
		try {
			// cenario
			Usuario usuario = new Usuario();
			// acao
			usuario.setRa("1234");
			usuario.setNome("Luis Fernando");
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}

	@Test
	public void CT02CadastrarUsuarioComRaEmBranco() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setNome("Luis Fernando");

		try {

			// acao
			usuario.setRa("");
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA invalido", e.getMessage());
		}
	}

	@Test
	public void CT03CadastrarUsuarioComRaNulo() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setNome("Luis Fernando");

		try {

			// acao
			usuario.setRa(null);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("RA invalido", e.getMessage());
		}
	}

	@Test
	public void CT04CadastrarUsuarioComNomeEmBranco() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setRa("123");

		try {
			// acao
			usuario.setNome("");
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome invalido", e.getMessage());
		}
	}

	@Test
	public void CT05CadastrarUsuarioComNomeNulo() {
		// cenario
		Usuario usuario = new Usuario();
		usuario.setRa("123");
		try {
			// acao
			usuario.setNome(null);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Nome invalido", e.getMessage());
		}
	}
	
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

}
