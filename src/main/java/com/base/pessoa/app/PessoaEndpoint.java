package com.base.pessoa.app;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.base.pessoa.entity.Caracteristica;
import com.base.pessoa.entity.Pessoa;
import com.base.pessoa.service.CaracteristicaService;
import com.base.pessoa.service.PessoaService;

@Path("/")
public class PessoaEndpoint {

	@Inject
	private PessoaService pessoaService;
	
	@Inject
	private CaracteristicaService caracteristicaService;

	@Path("/pessoa/retornarPessoas")
    @GET @Produces({MediaType.APPLICATION_JSON})
    public List<Pessoa> retornarPessoas() {
		return pessoaService.retornarPessoas();
	}

	@Path("/pessoa/gravarPessoa")
    @POST @Consumes({MediaType.APPLICATION_JSON})
    public void gravarPessoa(Pessoa pessoa) {
		pessoaService.gravarPessoa(pessoa);
	}
	
	@Path("/pessoa/alterarPessoa")
    @PUT @Consumes({MediaType.APPLICATION_JSON})
    public void alterarPessoa(Pessoa pessoa) {
		pessoaService.alterarPessoa(pessoa);
	}

	@Path("/pessoa/buscarPessoas")
    @POST @Consumes({MediaType.APPLICATION_JSON}) @Produces({MediaType.APPLICATION_JSON})
    public List<Pessoa> buscarPessoas(Pessoa pessoa) {
		return pessoaService.buscarPessoasJuridicas(pessoa);
	}
	
	@Path("/retornarCategorias")
    @GET @Produces({MediaType.APPLICATION_JSON})
    public List<Caracteristica> retornarCategorias() {
		return caracteristicaService.retornarFisicaCaracteristica();
	}

}
