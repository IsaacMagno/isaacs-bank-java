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
import org.isaacbank.dto.WithdrawDTO;
import org.isaacbank.service.WithdrawService;

@Path("/withdraw")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WithdrawController {
  @Inject
  private WithdrawService service;

  @GET
  public Response listarSaques() {
    return Response.ok(service.listarSaques()).build();
  }

  @GET
  @Path("/{id}")
  public Response buscarSaque(@PathParam("id") Integer id) {
    return Response.ok(service.buscarSaque(id)).build();
  }

  @POST
  public Response sacar(WithdrawDTO dto) {
    service.sacar(dto);
    return Response.status(Response.Status.CREATED).build();
  }

  @PATCH
  @Path("/{id}")
  public Response modificar(@PathParam("id") Integer id, WithdrawDTO dto) {
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
