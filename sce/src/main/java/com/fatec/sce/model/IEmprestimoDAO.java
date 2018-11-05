package com.fatec.sce.model;

public interface IEmprestimoDAO {
	public int adiciona(Emprestimo emprestimo);

	public int exclui(int emprestimoNumero);

	public Emprestimo consulta(int emprestimoNumero);
}