package org.expansao.controller;

import org.expansao.dto.ProdutoDto;
import org.expansao.service.ProdutoService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/produto")
public class ProdutoController {

    @Inject
    private ProdutoService produtoService;

    @GET
    @Path("/loja/{idLoja}")
    public Response buscaProdutosPorLoja(long idLoja){
        return Response.ok(produtoService.produtosPorLoja(idLoja)).build();
    }

    @POST
    @Transactional
    public Response criaNovoProduto(ProdutoDto produto){
        try {
            produtoService.adicionarProduto(produto);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response editaProduto(ProdutoDto produto,long id){
        try {
            produtoService.editarProduto(produto, id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response removeProduto(long id){
        try {
            produtoService.deletarProduto(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }


}
