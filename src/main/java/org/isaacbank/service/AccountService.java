package org.isaacbank.service;

import org.isaacbank.dto.AccountDTO;
import org.isaacbank.entity.AccountEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AccountService {
  public List<AccountEntity> listar() {
    return AccountEntity.listAll();
  }

  public AccountEntity conta(Integer id) {
    return AccountEntity.findById(id);
  }

  public void novaConta(AccountDTO dto) {
    AccountEntity conta = new AccountEntity();
    conta.setNome(dto.getNome());
    conta.persist();
  }
}
