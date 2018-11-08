package com.fatec.sce.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.fatec.sce.model.LivroDAO;
import com.fatec.sce.model.UsuarioDAO;


public class EmprestimoDAO implements IEmprestimoDAO {
	Logger logger = Logger.getLogger(UsuarioDAO.class);

	public int adiciona(Emprestimo emprestimo) {
		PreparedStatement ps;
		int codigoRetorno = 0;
		try (Connection conn = MySQLDAOFactory.createConnection()) {
			ps = (PreparedStatement) conn.prepareStatement("insert into emprestimo (emprestimoNumero, dataEmprestimo, dataDevolucao, Livro_isbn, Usuario_ra) values(?,?,?,?,?)");
			ps.setString(1, String.valueOf(emprestimo.getEmprestimoNumero()));
			ps.setString(2,emprestimo.getDataEmprestimo());
			ps.setString(3, emprestimo.getDataDevolucao());
			ps.setString(4, emprestimo.getLivro().getIsbn());
			ps.setString(5, emprestimo.getUsuario().getRa());
			codigoRetorno = ps.executeUpdate();
			logger.info("codigo de retorno do metodo adiciona emprestimo = " + codigoRetorno);
			ps.close();
		} catch (SQLException e) {
			logger.info("erro = " + e.getMessage());
			throw new RuntimeException(e);
		}
		return codigoRetorno;
	}

	public int exclui(int emprestimoNumero) {
		java.sql.PreparedStatement ps;
		int codigoretorno = 0;
		try (Connection conn = MySQLDAOFactory.createConnection()) {
			ps = conn.prepareStatement("delete from Emprestimo where emprestimoNumero = ?");
			ps.setString(1, String.valueOf(emprestimoNumero));
			codigoretorno = ps.executeUpdate();
		} catch (SQLException e) {
			logger.info("erro = " + e.getMessage());
			throw new RuntimeException(e);
		}
		return codigoretorno;
	}

	public Emprestimo consulta(int emprestimoNumero) {
		Emprestimo emprestimo = null;
		Livro livro = null;
		Usuario usuario = null;
		java.sql.PreparedStatement ps;
		try (Connection conn = MySQLDAOFactory.createConnection()) {
			ps = conn.prepareStatement("select * from Emprestimo where emprestimoNumero = ?");
			ps.setString(1, String.valueOf(emprestimoNumero));
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				emprestimo = new Emprestimo();
				
				
				emprestimo.setEmprestimoNumero(resultSet.getInt("emprestimoNumero"));
				emprestimo.setDataEmprestimo(resultSet.getString("dataEmprestimo"));
				
				livro = new Livro();
				String isbn = resultSet.getString("Livro_isbn");
				livro = construtorLivro(isbn);
				
				usuario = new Usuario();
				String Usuario_ra = resultSet.getString("Usuario_ra");
				usuario = construtorUsuario(Usuario_ra);
				
				emprestimo.setLivro(livro);
				emprestimo.setUsuario(usuario);
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			logger.info("erro metodo consulta usuario = " + e.getMessage());
		} catch (Exception e) {
			logger.info("erro metodo consulta usuario = " + e.getMessage());
		}
		return emprestimo;
	}
	
	private Livro construtorLivro (String isbn)
	{
		Livro livro = new Livro();
		
		LivroDAO acessaLivro = new LivroDAO();
		
		livro = acessaLivro.consulta(isbn);
		
		return livro;
		
	}
	
	private Usuario construtorUsuario(String Usuario_ra)
	{
		Usuario usuario = new Usuario();
		
		UsuarioDAO acessaUsuario = new UsuarioDAO();
		
		usuario = acessaUsuario.consulta(Usuario_ra);
		
		return usuario;
	}
}