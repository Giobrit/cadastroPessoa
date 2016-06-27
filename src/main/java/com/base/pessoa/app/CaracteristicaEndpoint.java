package com.base.pessoa.app;

import com.base.pessoa.entity.Caracteristica;
import com.base.pessoa.service.CaracteristicaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/caracteristica")
public class CaracteristicaEndpoint {

    @Inject
    private CaracteristicaService caracteristicaService;


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Caracteristica> retornarCaracteristicas() {
        return caracteristicaService.retornarCaracteristicas();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Caracteristica gravarCaracteristica(Caracteristica caracteristica) {
       return caracteristicaService.gravarCaracteristica(caracteristica);
    }

    @Path("/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Caracteristica alterarCaracteristica(Caracteristica caracteristica) {
        return caracteristicaService.alterarCaracteristica(caracteristica);
    }

    @Path("/{id}")
    @GET @Consumes({MediaType.APPLICATION_JSON}) @Produces({MediaType.APPLICATION_JSON})
    public Caracteristica buscarCaracteristica(@PathParam("id") Long id) {
        return caracteristicaService.buscarCaracteristica(id);
    }

    @Path("/{id}")
    @DELETE @Consumes({MediaType.APPLICATION_JSON}) @Produces({MediaType.APPLICATION_JSON})
    public void excluirCaracteristica(@PathParam("id") Long id) {
        caracteristicaService.excluirCaracteristica(id);
    }
}
