package org.isaacbank.controller;

import org.isaacbank.service.AccountService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
