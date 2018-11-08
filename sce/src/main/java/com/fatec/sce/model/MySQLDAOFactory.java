package com.fatec.sce.model;

import com.mysql.jdbc.Connection;

public class MySQLDAOFactory extends DAOFactory {
	public static Connection createConnection() {
		return (Connection) new FabricaDeConexoes().getConnection();
	}

	@Override
	public LivroDAO getLivroDAO() {
		return new LivroDAO();
	}
	
	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO();
	}
	
	@Override
	public EmprestimoDAO getEmprestimoDAO() {
		return new EmprestimoDAO();
	}
}