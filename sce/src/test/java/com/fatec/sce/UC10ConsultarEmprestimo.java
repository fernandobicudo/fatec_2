package com.fatec.sce;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fatec.sce.model.DAOFactory;
import com.fatec.sce.model.Emprestimo;

public class UC10ConsultarEmprestimo {

	
	@Test
	public void CT01CadastrarEmprestimo_com_sucesso() {
//cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDadosValidos();
		Emprestimo resultadoObtido = null;
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
//		IUsuarioDAO usuarioDAO = mySQLFactory.getUsuarioDAO();
//acao
		emprestimoDAO.adiciona(umEmprestimo);
		resultadoObtido = emprestimoDAO.consulta(umUsuario.getRa());
//verificacao
		assertTrue(resultadoObtido.equals(umUsuario));
		emprestimoDAO.exclui(umUsuario.getRa());
	}
}
