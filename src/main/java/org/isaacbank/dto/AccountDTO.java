package org.isaacbank.dto;

import java.util.List;
import org.isaacbank.entity.BillEntity;
import org.isaacbank.entity.DepositEntity;
import org.isaacbank.entity.WithdrawEntity;

public class AccountDTO {
  public List<DepositEntity> deposits;
  public List<WithdrawEntity> withdrawals;

  public List<BillEntity> bills;
  public String nome;

  public Double saldo;

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

  public List<BillEntity> getBills() {
    return bills;
  }

  public void setBills(List<BillEntity> bills) {
    this.bills = bills;
  }
}
