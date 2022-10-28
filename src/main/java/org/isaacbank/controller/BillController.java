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
import org.isaacbank.dto.BillDTO;
import org.isaacbank.service.BillService;

@Path("/bill")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BillController {

  @Inject
  private BillService service;

  @GET
  public Response listarContas() {
    return Response.ok(service.listarContas()).build();
  }

  @GET
  @Path("/{id}")
  public Response selecionarConta(@PathParam("id") Integer id) {
    return Response.ok(service.selecionarConta(id)).build();
  }

  @POST
  public Response adicionarConta(BillDTO dto) {
    service.adicionarConta(dto);
    return Response.status(Status.CREATED).build();
  }

  @PATCH
  @Path("/{id}")
  public Response atualizarConta(@PathParam("id") Integer id, BillDTO dto) {
    service.atualizarConta(id, dto);
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  public Response deletar(@PathParam("id") Integer id) {
    service.deletar(id);
    return Response.ok().build();
  }
}
