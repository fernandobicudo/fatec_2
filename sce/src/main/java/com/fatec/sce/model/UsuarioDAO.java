package com.fatec.sce.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class UsuarioDAO implements IUsuarioDAO {
	Logger logger = Logger.getLogger(UsuarioDAO.class);

	public int adiciona(Usuario usuario) {
		PreparedStatement ps;
		int codigoRetorno = 0;
		try (Connection conn = MySQLDAOFactory.createConnection()) {
			ps = (PreparedStatement) conn.prepareStatement("insert into Usuario (ra, nome) values(?,?)");
			ps.setString(1, usuario.getRa());
			ps.setString(2, usuario.getNome());
			codigoRetorno = ps.executeUpdate();
			logger.info("codigo de retorno do metodo adiciona usuario = " + codigoRetorno);
			ps.close();
		} catch (SQLException e) {
			logger.info("erro = " + e.getMessage());
			throw new RuntimeException(e);
		}
		return codigoRetorno;
	}

	public int exclui(String ra) {
		java.sql.PreparedStatement ps;
		int codigoretorno = 0;
		try (Connection conn = MySQLDAOFactory.createConnection()) {
			ps = conn.prepareStatement("delete from Usuario where ra = ?");
			ps.setString(1, ra);
			codigoretorno = ps.executeUpdate();
		} catch (SQLException e) {
			logger.info("erro = " + e.getMessage());
			throw new RuntimeException(e);
		}
		return codigoretorno;
	}

	public Usuario consulta(String ra) {
		Usuario usuario = null;
		java.sql.PreparedStatement ps;
		try (Connection conn = MySQLDAOFactory.createConnection()) {
			ps = conn.prepareStatement("select * from Usuario where ra = ?");
			ps.setString(1, ra);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				usuario = new Usuario();
				usuario.setRa(resultSet.getString("ra"));
				usuario.setNome(resultSet.getString("nome"));
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			logger.info("erro metodo consulta usuario = " + e.getMessage());
		} catch (Exception e) {
			logger.info("erro metodo consulta usuario = " + e.getMessage());
		}
		return usuario;
	}
}