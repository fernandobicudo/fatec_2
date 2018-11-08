package com.fatec.sce;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.fatec.sce.model.DAOFactory;
import com.fatec.sce.model.Emprestimo;
import com.fatec.sce.model.IEmprestimoDAO;

public class UC10ConsultarEmprestimo {

	
	@Test
	public void CT01CadastrarEmprestimo_com_sucesso() {
//cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDadosValidos();
		Emprestimo resultadoObtido = null;
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		IEmprestimoDAO emprestimoDAO = mySQLFactory.getEmprestimoDAO();
//acao
		emprestimoDAO.adiciona(umEmprestimo);
		resultadoObtido = emprestimoDAO.consulta(umEmprestimo.getEmprestimoNumero());
//verificacao
		assertTrue(resultadoObtido.equals(umEmprestimo));
		emprestimoDAO.exclui(umEmprestimo.getEmprestimoNumero());
	}
}
