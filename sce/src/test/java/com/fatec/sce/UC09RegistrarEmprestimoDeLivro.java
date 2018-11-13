package com.fatec.sce;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import com.fatec.sce.model.Emprestimo;
import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;
import com.fatec.sce.servico.ServicoEmprestimo;

public class UC09RegistrarEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;

	@Test
	public void CT01RegistraEmprestimoDeLivro_com_sucesso() {
		// cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		usuario.setRa("1111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
		// acao
		Emprestimo resultadoEsperado = servico.empresta(123, livro, usuario);
		// verificação
		assertNotNull(resultadoEsperado);
	}

	@Test
	public void CT02RegistraEmprestimoDeLivro_com_sucesso() {
		// cenario
		Emprestimo emprestimo = null;
		// acao
		emprestimo = ObtemEmprestimo.comDadosValidos();
		// verificação
		assertNotNull(emprestimo);
	}

	@Test
	public void CT02UC01FB_registra_emprestimo_com_sucesso_validacao_da_data() {
		// cenario
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		ServicoEmprestimo servico = null;
		// acao
		Emprestimo emprestimo = ObtemEmprestimo.comDadosValidos();
		String dataObtida = emprestimo.getDataDevolucao();
		// verificacao
		assertTrue(dataEsperada.equals(dataObtida));
	}

	@Test
	public void CT02UC01FB_registra_emprestimo_com_data_emprestimo_invalida() {
		// cenario
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		ServicoEmprestimo servico = null;
		Emprestimo emprestimo = new Emprestimo();
		// acao
		try {
			emprestimo = ObtemEmprestimo.comDataEmprestimoInvalida();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			assertTrue(dataEsperada.equals(emprestimo.getDataEmprestimo()));
		}

	}

	@Test
	public void CT02UC01FB_registra_emprestimo_com_data_devolucao_invalida() {
		// cenario
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		ServicoEmprestimo servico = null;
		Emprestimo emprestimo = new Emprestimo();
		// acao
		try {
			emprestimo = ObtemEmprestimo.comDataDevolucaoInvalida();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			assertTrue(dataEsperada.equals(emprestimo.getDataDevolucao()));
		}

	}

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de usuario com
	 * RA em branco.
	 **/

	@Test
	public void CT02CadastrarEmprestimoComRaEmBranco() {
		// cenario
		Emprestimo emprestimo = new Emprestimo();

		try {

			// acao
			emprestimo = ObtemEmprestimo.AlunocomRAInvalido_branco();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de usuario com
	 * RA nulo.
	 **/

	@Test
	public void CT03CadastrarEmprestimoComRaNulo() {
		// cenario
		Emprestimo emprestimo = new Emprestimo();

		try {

			// acao
			emprestimo = ObtemEmprestimo.AlunocomRAInvalido_nulo();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de usuario com
	 * nome em branco.
	 **/

	@Test
	public void CT04CadastrarEmprestimoComNomeEmBranco() {
		// cenario
		Emprestimo emprestimo = new Emprestimo();

		try {
			// acao
			emprestimo = ObtemEmprestimo.AlunocomNomeEmBranco();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de usuario com
	 * nome nulo.
	 **/

	@Test
	public void CT05CadastrarEmprestimoComNomeNulo() {
		// cenario
		Emprestimo emprestimo = new Emprestimo();

		try {
			// acao
			emprestimo = ObtemEmprestimo.AlunocomNomeNulo();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de livro com
	 * ISBN nulo.
	 **/

	@Test
	public void CT05CadastrarEmprestimocomISBNInvalido_nulo() {
		// cenario
		Emprestimo emprestimo = new Emprestimo();

		try {
			// acao
			emprestimo = ObtemEmprestimo.comLivrocomISBNInvalido_nulo();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}

	/**
	 * Objetivo - verificar o comportamento da aplicacao na inclusao de livro com
	 * ISBN em branco.
	 **/

	@Test
	public void CT05CadastrarEmprestimoComISBNemBranco() {
		// cenario
		Emprestimo emprestimo = new Emprestimo();

		try {
			// acao
			emprestimo = ObtemEmprestimo.comLivrocomISBNInvalido_branco();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}

	@Test
	public void CT05CadastrarEmprestimoComNumeroInvalido() {
		// cenario
		Emprestimo emprestimo = new Emprestimo();

		try {
			// acao
			emprestimo = ObtemEmprestimo.comNumEmprestimoInvalido();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}

	@Test
	public void CT05CadastrarEmprestimoComLivroNulo() {
		// cenario

		try {
			// acao
			Emprestimo emprestimo = new Emprestimo();
			emprestimo = ObtemEmprestimo.comLivroNulo();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}

	@Test
	public void CT05CadastrarEmprestimoComUsuarioNulo() {
		// cenario
		Emprestimo emprestimo = new Emprestimo();

		try {
			// acao
			emprestimo = ObtemEmprestimo.comUsuarioNulo();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}

	@Test
	public void CT05CadastrarEmprestimoComTudoNulo() {
		// cenario
		Emprestimo emprestimo = new Emprestimo();

		try {
			// acao
			emprestimo = ObtemEmprestimo.comTudoNulo();
			fail("deveria lançar uma exceção");
		} catch (RuntimeException e) {
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage());
		}
	}

	/**
	 * Objetivo - verificar o comportamento do metodo ehDomigo() para uma data com
	 * formato valido dia invalido (domingo).
	 */
	@Test
	public void CT06se_data_devolucao_for_domingo_retorna_true() {
		// cenario
		String data = "2018/09/02"; // domingo
		// acao
		Emprestimo umEmprestimo = new Emprestimo();
		// verificacao
		assertTrue(umEmprestimo.ehDomingo(data));
	}

	@Test
	public void CT07_quando_entrega_atrasado_quant_dias_negativo() {
		// cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoVencida();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		// acao
		int quantDias = servico.devolucao(umEmprestimo);
		// verificacao
		assertTrue(quantDias < 0); // quant de dias entre a data de emprestimo e a de devolucao
	}

}
