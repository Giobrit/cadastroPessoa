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

    public Pessoa gravarPessoa(Pessoa pessoa) {
        return pessoaDAO.gravarPessoa(pessoa);
    }

    public List<Pessoa> retornarPessoas() {
        return pessoaDAO.retornarPessoas();
    }

    public Pessoa buscarPessoa(Long id) {
        return pessoaDAO.buscarPessoa(id);
    }

    public void excluir(Long id) {
        pessoaDAO.excluirPessoa(id);
    }

    public Pessoa alterarPessoa(Pessoa pessoa) {
        return pessoaDAO.alterarPessoa(pessoa);
    }

}
