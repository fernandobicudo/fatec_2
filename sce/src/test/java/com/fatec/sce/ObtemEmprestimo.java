package com.fatec.sce;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fatec.sce.model.Emprestimo;
import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;
import com.fatec.sce.servico.ServicoEmprestimo;

public class ObtemEmprestimo {

	public static Emprestimo comDadosValidos() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(2, livro, aluno);
	}

	public static Emprestimo comDataEmprestimoInvalida() {

		Emprestimo emprestimo = new Emprestimo();
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		emprestimo = servico.empresta(2, livro, aluno);

		emprestimo.setDataEmprestimo("2018-13-32");

		return emprestimo;
	}

	public static Emprestimo comDataDeDevolucaoVencida() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		int numeroEmprestimo = 2;
		Emprestimo umEmprestimo = servico.empresta(numeroEmprestimo, livro, aluno);
		DateTime dataAtual = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		umEmprestimo.setDataEmprestimo(dataAtual.minusDays(12).toString(fmt));
		umEmprestimo.setDataDevolucao(dataAtual.minusDays(4).toString(fmt));
		return umEmprestimo;
	}

	public static Emprestimo comDataDevolucaoInvalida() {

		Emprestimo emprestimo = new Emprestimo();
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		emprestimo = servico.empresta(2, livro, aluno);

		emprestimo.setDataDevolucao("2018-13-32");

		return emprestimo;
	}

	public static Emprestimo AlunocomRAInvalido_nulo() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comRAInvalido_nulo();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(3, livro, aluno);
	}

	public static Emprestimo AlunocomRAInvalido_branco() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comRAInvalido_branco();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(4, livro, aluno);
	}

	public static Emprestimo comLivrocomISBNInvalido_branco() {
		Livro livro = ObtemLivro.comISBNInvalido_branco();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(5, livro, aluno);
	}

	public static Emprestimo AlunocomNomeEmBranco() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comNomeEmBranco();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(6, livro, aluno);
	}

	public static Emprestimo AlunocomNomeNulo() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comNomeNulo();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(7, livro, aluno);
	}

	public static Emprestimo comLivrocomISBNInvalido_nulo() {
		Livro livro = ObtemLivro.comISBNInvalido_nulo();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(8, livro, aluno);
	}

	public static Emprestimo comNumEmprestimoInvalido() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(null, livro, aluno);
	}

	public static Emprestimo comLivroNulo() {
		Livro livro = ObtemLivro.objetoNulo();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(7, livro, aluno);
	}

	public static Emprestimo comUsuarioNulo() {
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.objetoNulo();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(8, livro, aluno);
	}

	public static Emprestimo comTudoNulo() {
		Livro livro = ObtemLivro.objetoNulo();
		Usuario aluno = ObtemUsuario.objetoNulo();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		return servico.empresta(8, livro, aluno);
	}

}