package org.isaacbank.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class AccountEntity extends PanacheEntityBase {

  @OneToMany(
      mappedBy = "account",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.EAGER)
  public List<DepositEntity> deposits = new ArrayList<DepositEntity>();

  @OneToMany(
      mappedBy = "account",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  public List<WithdrawEntity> withdrawals = new ArrayList<WithdrawEntity>();

  @OneToMany(
      mappedBy = "account",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  public List<BillEntity> bills = new ArrayList<BillEntity>();

  @OneToMany(
      mappedBy = "account",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  public List<FutureExpensesEntity> expenses = new ArrayList<FutureExpensesEntity>();

  @Column public String nome;

  @Column public Double saldo = 0d;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "accountId")
  private Integer id;

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
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

  public List<FutureExpensesEntity> getExpenses() {
    return expenses;
  }

  public void setExpenses(List<FutureExpensesEntity> expenses) {
    this.expenses = expenses;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo += saldo;
  }
}
