package com.fatec.sce;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fatec.sce.model.DAOFactory;
import com.fatec.sce.model.Emprestimo;

public class UC10ConsultarEmprestimo {

	
	@Test
	public void CT01CadastrarEmprestimo_com_sucesso() {
//cenario
		Emprestimo umUsuario = ObtemEmprestimo.comDadosValidos();
		Emprestimo resultadoObtido = null;
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
//		IUsuarioDAO usuarioDAO = mySQLFactory.getUsuarioDAO();
//acao
		usuarioDAO.adiciona(umUsuario);
		resultadoObtido = usuarioDAO.consulta(umUsuario.getRa());
//verificacao
		assertTrue(resultadoObtido.equals(umUsuario));
		usuarioDAO.exclui(umUsuario.getRa());
	}
}
