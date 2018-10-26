package com.fatec.sce;

import static org.junit.Assert.*;
import static com.fatec.sce.ObtemLivro.*;

import org.junit.Test;

import com.fatec.sce.model.DAOFactory;
import com.fatec.sce.model.ILivroDAO;
import com.fatec.sce.model.Livro;

public class UC01CadastrarLivro {

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de dados
	 * válidos e cadastro com sucesso.
	 **/

	@Test
	public void CT01CadastrarLivroComDadosValidos() {
		try {
			// cenario
			Livro umLivro;
			// acao
			umLivro = ObtemLivro.comDadosValidos();
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de ISBN em
	 * branco.
	 **/

	@Test
	public void CT02cadastrarLivroComISBN_em_branco() {
		// cenario
		Livro livro;
		try {
			livro = ObtemLivro.comISBNInvalido_branco();
			// acao
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de ISBN nulo.
	 **/

	@Test
	public void CT03cadastrarLivroComISBN_nulo() {
		// cenario
		Livro livro;
		try {
			// acao
			livro = ObtemLivro.comISBNInvalido_nulo();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de Título em
	 * branco.
	 **/

	@Test
	public void CT04cadastrarLivroComTitulo_em_branco() {
		// cenario
		Livro livro = new Livro();
		livro.setIsbn("121212121");
		livro.setAutor("Pressman");
		try {
			// acao
			livro.setTitulo("");
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo invalido", e.getMessage());
		}
	}

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de Título nulo.
	 **/

	@Test
	public void CT05cadastrarLivroComTitulo_nulo() {
		// cenario
		Livro livro = new Livro();
		livro.setIsbn("121212121");
		livro.setAutor("Pressman");
		try {
			// acao
			livro.setTitulo(null);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo invalido", e.getMessage());
		}
	}

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de Autor em
	 * branco.
	 **/

	@Test
	public void CT06cadastrarLivroComAutor_em_branco() {
		// cenario
		Livro livro = new Livro();
		livro.setIsbn("121212121");
		livro.setTitulo("Engenharia de Software");
		try {
			// acao
			livro.setAutor("");
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo invalido", e.getMessage());
		}
	}

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de Autor nulo.
	 **/

	@Test
	public void CT07cadastrarLivroComAutor_nulo() {
		// cenario
		Livro livro = new Livro();
		livro.setIsbn("121212121");
		livro.setTitulo("Engenharia de Software");
		try {
			// acao
			livro.setAutor(null);
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo invalido", e.getMessage());
		}

	}

	@Test
	public void CT11CadastrarLivro_com_sucesso() {
		// cenario
		Livro umLivro = ObtemLivro.comDadosValidos();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ILivroDAO livroDAO = mySQLFactory.getLivroDAO();
		// acao
		int codigoRetorno = livroDAO.adiciona(umLivro);
		// verificacao
		assertEquals(1, codigoRetorno);
		livroDAO.exclui(umLivro.getIsbn());
	}

	@Test
	public void CT11CadastrarLivro_ISBN_ja_cadastrado() {
		// cenario
		Livro umLivro = ObtemLivro.comDadosValidos();
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ILivroDAO livroDAO = mySQLFactory.getLivroDAO();
		// acao
		try {
			livroDAO.adiciona(umLivro);
			livroDAO.adiciona(umLivro);
		} catch (Exception e) {
			livroDAO.exclui(umLivro.getIsbn());
			assertEquals(e.getMessage(),
					"com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '"
							+ umLivro.getIsbn() + "' for key 'isbn'");
		}

	}
}
/**
 * 
 * 
 * @Test public void CT08cadastrarLivro_com_sucesso() { // cenario Livro livro =
 *       new Livro(); livro.setIsbn("121212121"); livro.setTitulo("Engenharia de
 *       Software"); livro.setAutor("Pressman"); assertEquals("Engenharia de
 *       Software", livro.getTitulo()); }
 * 
 * 
 * @Test public void CT09cadastrarLivro_com_sucesso() { // cenario Livro livro =
 *       new Livro(); livro.setIsbn("121212121"); livro.setTitulo("Engenharia de
 *       Software"); livro.setAutor("Pressman"); assertEquals("121212121",
 *       livro.getIsbn()); }
 * 
 * 
 * 
 * @Test public void CT10cadastrarLivro_com_sucesso() { // cenario Livro livro =
 *       new Livro(); livro.setIsbn("121212121"); livro.setTitulo("Engenharia de
 *       Software"); livro.setAutor("Pressman"); assertEquals("Pressman",
 *       livro.getAutor()); }
 * 
 **/
