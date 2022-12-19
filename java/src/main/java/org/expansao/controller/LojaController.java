package org.expansao.controller;

import org.expansao.dto.LojaDto;
import org.expansao.service.LojaService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/loja")
public class LojaController {

    @Inject
    private LojaService lojaService;


    @GET
    public Response buscaLojas() throws Exception {
        return Response.ok(lojaService.buscaLojas()).build();
    }

    @POST
    @Transactional
    public Response criaNovaLoja(LojaDto loja){
        try {
            lojaService.adicionaLoja(loja);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
