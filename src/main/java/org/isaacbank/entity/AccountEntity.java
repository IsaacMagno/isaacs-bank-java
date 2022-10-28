package org.isaacbank.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountEntity extends PanacheEntityBase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "accountId")
  private Integer id;

  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  public List<DepositEntity> deposits = new ArrayList<DepositEntity>();

  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  public List<WithdrawEntity> withdrawals = new ArrayList<WithdrawEntity>();

  @Column
  String nome;

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
}
