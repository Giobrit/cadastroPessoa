package com.base.pessoa.dao;

import java.util.List;

import com.base.pessoa.entity.Pessoa;

public interface PessoaDAOInterface{

	Pessoa gravarPessoa(Pessoa pessoa);
	List<Pessoa> retornarPessoas();
	Pessoa buscarPessoa(Long id);
	void excluirPessoa(Long id);
	Pessoa alterarPessoa(Pessoa pessoa);
	
	
}
