package com.fatec.sce;

import static org.junit.Assert.*;
import org.junit.Test;
import com.fatec.sce.model.DAOFactory;
import com.fatec.sce.model.IUsuarioDAO;
import com.fatec.sce.model.Usuario;


public class UC06ConsultarUsuario {
	
	@Test
	public void CT01CadastrarUsuario_com_sucesso() {
//cenario
		Usuario umUsuario = ObtemUsuario.comDadosValidos();
		Usuario resultadoObtido = null;
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		IUsuarioDAO usuarioDAO = mySQLFactory.getUsuarioDAO();
//acao
		usuarioDAO.adiciona(umUsuario);
		resultadoObtido = usuarioDAO.consulta(umUsuario.getRa());
//verificacao
		assertTrue(resultadoObtido.equals(umUsuario));
		usuarioDAO.exclui(umUsuario.getRa());
	}


}
