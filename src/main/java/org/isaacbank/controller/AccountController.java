package org.isaacbank.controller;

import org.isaacbank.dto.AccountDTO;
import org.isaacbank.entity.AccountEntity;
import org.isaacbank.service.AccountService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/account")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountController {
  @Inject
  private AccountService service;

  @GET
  public Response listar() {
    return Response.ok(service.listar()).build();
  }

  @GET
  @Path("/{id}")
  public Response conta(@PathParam("id") Integer id) {
    return Response.ok(service.conta(id)).build();
  }

  @Transactional
  @POST
  public Response novaConta(AccountDTO dto) {
    service.novaConta(dto);
    return Response.ok(Response.Status.CREATED).build();
  }
}
