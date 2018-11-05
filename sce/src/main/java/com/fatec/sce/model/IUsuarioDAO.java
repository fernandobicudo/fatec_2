package com.fatec.sce.model;

public interface IUsuarioDAO {
	public int adiciona(Usuario usuario);

	public int exclui(String ra);
	public Usuario consulta(String ra);
}