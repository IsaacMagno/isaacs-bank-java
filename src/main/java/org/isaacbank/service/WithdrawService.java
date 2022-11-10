package org.isaacbank.service;

import java.time.LocalDate;
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
    withdraw.setCategoria(dto.getCategoria());
    withdraw.setValor(dto.getValor());
    withdraw.setData(LocalDate.now());
    withdraw.setAccount(account);
    withdraw.persist();

    account.withdrawals.add(withdraw);
    account.setSaldo(-dto.getValor());
    account.persist();
  }

  @Transactional
  public void modificar(Integer id, WithdrawDTO dto) {
    AccountEntity account = AccountEntity.findById(1);
    WithdrawEntity withdraw = WithdrawEntity.findById(id);

    if (dto.getValor() > withdraw.getValor()) {
      account.setSaldo(-(dto.getValor() - withdraw.getValor()));
    }

    if (dto.getValor() < withdraw.getValor()) {
      account.setSaldo(withdraw.getValor() - dto.getValor());
    }

    withdraw.setValor(dto.getValor());
    withdraw.setData(LocalDate.now());
    withdraw.persist();
  }

  @Transactional
  public void deletar(Integer id) {
    WithdrawEntity.deleteById(id);
    WithdrawEntity withdraw = WithdrawEntity.findById(id);
    if (withdraw != null) {
      withdraw.account.withdrawals.remove(withdraw);
      withdraw.delete();
    }
  }

  public List<WithdrawEntity> listarSaques() {
    return WithdrawEntity.listAll();
  }

  public WithdrawEntity buscarSaque(Integer id) {
    return WithdrawEntity.findById(id);
  }
}
