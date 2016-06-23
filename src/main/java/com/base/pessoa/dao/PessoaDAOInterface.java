package com.base.pessoa.dao;

import java.util.List;

import com.base.pessoa.entity.Pessoa;

public interface PessoaDAOInterface{

	void gravarPessoa(Pessoa pessoa);
	List<Pessoa> retornarPessoas();
	Pessoa buscarPessoa(Long id);
	List<Pessoa> buscarPessoas(Pessoa pessoa);
	void excluirPessoa(Long id);
	void alterarPessoa(Pessoa pessoa);
	
	
}
