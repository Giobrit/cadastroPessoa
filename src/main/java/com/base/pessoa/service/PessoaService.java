package com.base.pessoa.service;

import java.util.List;

import com.base.pessoa.dao.PessoaDAO;
import com.base.pessoa.entity.Pessoa;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class PessoaService {
	
	@Inject
	private PessoaDAO pessoaDAO;
	
	public void gravarPessoa(Pessoa pessoa) {
		pessoaDAO.gravarPessoa(pessoa);	
	}
	
	public List<Pessoa> retornarPessoas() {
		return pessoaDAO.retornarPessoas();
	}

	public Pessoa buscarPessoa(Long id) {
		return pessoaDAO.buscarPessoa(id);
	}

	public void excluirPessoaJuridica(Long id) {
		pessoaDAO.excluirPessoa(id);
	}

	public List<Pessoa> buscarPessoasJuridicas(Pessoa pessoa) {
		return pessoaDAO.buscarPessoas(pessoa);
	}
	public void alterarPessoa(Pessoa pessoa) {
		pessoaDAO.alterarPessoa(pessoa);	
	}

}
