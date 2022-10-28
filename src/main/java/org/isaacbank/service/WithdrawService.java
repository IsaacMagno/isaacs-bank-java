package org.isaacbank.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.isaacbank.dto.WithdrawDTO;
import org.isaacbank.entity.AccountEntity;
import org.isaacbank.entity.WithdrawEntity;

@ApplicationScoped
public class WithdrawService {
  @Transactional
  public void sacar(WithdrawDTO dto) {
    AccountEntity account = AccountEntity.findById(1);

    WithdrawEntity withdraw = new WithdrawEntity();
    withdraw.setDescricao(dto.getDescricao());
    withdraw.setValor(dto.getValor());
    withdraw.setData(dto.getData());
    withdraw.setAccount(account);
    withdraw.persist();

    account.withdrawals.add(withdraw);
    account.persist();
  }

  @Transactional
  public void modificar(Integer id, WithdrawDTO dto) {
    WithdrawEntity withdraw = WithdrawEntity.findById(id);
    withdraw.setDescricao(dto.getDescricao());
    withdraw.setValor(dto.getValor());
    withdraw.setData(dto.getData());
    withdraw.persist();
  }

  @Transactional
  public void deletar(Integer id) {
    WithdrawEntity.deleteById(id);
  }

  public List<WithdrawEntity> listarSaques() {
    return WithdrawEntity.listAll();
  }

  public WithdrawEntity buscarSaque(Integer id) {
    return WithdrawEntity.findById(id);
  }
}
