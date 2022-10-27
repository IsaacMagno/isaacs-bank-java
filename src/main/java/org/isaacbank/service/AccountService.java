package org.isaacbank.service;

import org.isaacbank.entity.AccountEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AccountService {
  public List<AccountEntity> listar() {
    return AccountEntity.listAll();
  }
}
