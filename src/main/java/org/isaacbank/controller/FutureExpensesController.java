package org.isaacbank.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.isaacbank.dto.FutureExpensesDTO;
import org.isaacbank.service.FutureExpensesService;

@Path("/expense")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FutureExpensesController {
  @Inject
  FutureExpensesService service;

  @GET
  public Response listarDespesasFuturas() {
    return Response.ok(service.listarDespesasFuturas()).build();
  }

  @GET
  @Path("/{id}")
  public Response selecionarDespesa(@PathParam("id") Integer id) {
    return Response.ok(service.selecionarDespesa(id)).build();
  }

  @POST
  public Response adicionarDespesa(FutureExpensesDTO dto) {
    service.adicionarDespesa(dto);
    return Response.status(Status.CREATED).build();
  }

  @PATCH
  @Path("/{id}")
  public Response atualizarDespesa(@PathParam("id") Integer id,
      FutureExpensesDTO dto) {
    service.atualizarDespesa(id, dto);
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  public Response deletar(@PathParam("id") Integer id) {
    service.deletar(id);
    return Response.ok().build();
  }
}
