package com.fatec.sce;

import com.fatec.sce.model.Usuario;

public class ObtemUsuario {
	public static Usuario comDadosValidos() {
		Usuario usuario = new Usuario();
		usuario.setRa("121212");
		usuario.setNome("Luis Fernando");
		return usuario;
	}

	public static Usuario comRAInvalido_branco() {
		Usuario usuario = new Usuario();
		usuario.setRa("");

		usuario.setNome("Luis Fernando");

		return usuario;
	}

	public static Usuario comRAInvalido_nulo() {
		Usuario usuario = new Usuario();
		usuario.setRa(null);

		usuario.setNome("Luis Fernando");

		return usuario;
	}
	
	public static Usuario comNomeEmBranco() {
		Usuario usuario = new Usuario();
		usuario.setRa("123456");

		usuario.setNome("");

		return usuario;
	}
	
	public static Usuario comNomeNulo() {
		Usuario usuario = new Usuario();
		usuario.setRa("123456");

		usuario.setNome(null);

		return usuario;
	}
	
	public static Usuario objetoNulo() {
		Usuario usuario = new Usuario();
		usuario = null;
		return usuario;
	}
}