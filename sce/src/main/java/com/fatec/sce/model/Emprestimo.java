package com.fatec.sce.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.management.RuntimeErrorException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Emprestimo {
	private Integer emprestimoNumero;
	private Livro livro;
	private Usuario usuario;
	private String dataEmprestimo;
	private String dataDevolucao;

	public int getEmprestimoNumero() {
		return emprestimoNumero;
	}

	public void setEmprestimoNumero(Integer emprestimoNumero) {
		if (emprestimoNumero != null) {
			this.emprestimoNumero = emprestimoNumero;
		} else {
			throw new RuntimeException("Dados inválidos.");
		}
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		if (livro != null) {
			this.livro = livro;
		} else {
			throw new RuntimeException("Dados inválidos.");
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		if (usuario != null) {
			this.usuario = usuario;
		} else {
			throw new RuntimeException("Dados inválidos.");
		}

	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		if (validaData(dataEmprestimo) == true) {
			this.dataEmprestimo = dataEmprestimo;
		} else {
			throw new RuntimeException("Data invalida.");
		}
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		if (validaData(dataDevolucao) == true) {
			this.dataDevolucao = dataDevolucao;
		} else {
			throw new RuntimeException("Data invalida.");
		}
	}

	/**
	 * valida o formato da data
	 * 
	 * @param data no formato yyyy/MM/dd
	 * @return true se a data estiver no formato valido e false para formato
	 *         invalido
	 */
	public boolean validaData(String data) {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		df.setLenient(false); //
		try {
			df.parse(data); // data válida
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}

/*	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

*/	

}
