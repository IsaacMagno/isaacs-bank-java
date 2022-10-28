package org.isaacbank.dto;

import org.isaacbank.entity.DepositEntity;
import org.isaacbank.entity.WithdrawEntity;

import java.util.List;
import java.util.Set;

public class AccountDTO {
  String nome;

  public List<DepositEntity> deposits;

  public List<WithdrawEntity> withdrawals;

  public String getNome() {
    return nome;
  }

  public void setNome(String name) {
    this.nome = name;
  }

  public List<DepositEntity> getDeposits() {
    return deposits;
  }

  public void setDeposits(List<DepositEntity> deposits) {
    this.deposits = deposits;
  }

  public List<WithdrawEntity> getWithdrawals() {
    return withdrawals;
  }

  public void setWithdrawals(List<WithdrawEntity> withdrawals) {
    this.withdrawals = withdrawals;
  }
}
