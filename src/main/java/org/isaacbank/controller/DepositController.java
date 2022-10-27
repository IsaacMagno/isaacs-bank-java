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
import org.isaacbank.dto.DepositDTO;
import org.isaacbank.service.DepositService;


@Path("/deposit")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepositController {
  @Inject
  private DepositService service;

  @GET
  public Response listarDepositos() {
    return Response.ok(service.listarDepositos()).build();
  }

  @GET
  @Path("/{id}")
  public Response buscarDeposito(@PathParam("id") Integer id) {
    return Response.ok((service.buscarDeposito(id))).build();
  }

  @POST
  public Response depositar(DepositDTO dto) {
    service.depositar(dto);
    return Response.status(Response.Status.CREATED).build();
  }

  @PATCH
  @Path("/{id}")
  public Response modificar(@PathParam("id") Integer id, DepositDTO dto) {
    service.modificar(id, dto);
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  public Response deletar(@PathParam("id") Integer id) {
    service.deletar(id);
    return Response.ok().build();
  }
}
