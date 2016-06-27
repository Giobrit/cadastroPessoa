package com.base.pessoa.app;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.base.pessoa.entity.Caracteristica;
import com.base.pessoa.entity.Pessoa;
import com.base.pessoa.service.CaracteristicaService;
import com.base.pessoa.service.PessoaService;

@Path("/pessoa")
public class PessoaEndpoint {

    @Inject
    private PessoaService pessoaService;

    @Inject
    private CaracteristicaService caracteristicaService;


    @GET @Produces({MediaType.APPLICATION_JSON})
    public List<Pessoa> retornarPessoas() {
        return pessoaService.retornarPessoas();
    }

    @POST @Consumes({MediaType.APPLICATION_JSON})  @Produces({MediaType.APPLICATION_JSON})
    public Pessoa gravarPessoa(Pessoa pessoa)
    {
      return  pessoaService.gravarPessoa(pessoa);
    }

    @Path("/{id}")
    @PUT @Consumes({MediaType.APPLICATION_JSON})  @Produces({MediaType.APPLICATION_JSON})
    public Pessoa alterarPessoa(Pessoa pessoa) {
        return pessoaService.alterarPessoa(pessoa);
    }

    @Path("/{id}")
    @GET @Consumes({MediaType.APPLICATION_JSON}) @Produces({MediaType.APPLICATION_JSON})
    public Pessoa buscarPessoa(@PathParam("id") Long id) {
        return pessoaService.buscarPessoa(id);
    }

    @Path("/{id}")
    @DELETE @Consumes({MediaType.APPLICATION_JSON}) @Produces({MediaType.APPLICATION_JSON})
    public void excluirPessoa(@PathParam("id") Long id) {
        pessoaService.excluir(id);
    }
}
