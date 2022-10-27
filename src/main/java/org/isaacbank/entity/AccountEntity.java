package org.isaacbank.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
public class AccountEntity extends PanacheEntityBase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idAccount")
  private Integer id;

  @OneToMany(mappedBy= "accountEntity")
  public List<DepositEntity> deposit;

  @OneToMany(mappedBy= "withdraw", cascade = CascadeType.ALL, orphanRemoval = true)
  public Set<WithdrawEntity> withdraw;

  private double saldo;

  public Integer getId() {
    return id;
  }

  public List<DepositEntity> getDeposit() {
    return deposit;
  }

  public void setDeposit(List<DepositEntity> deposit) {
    this.deposit = deposit;
  }

  public Set<WithdrawEntity> getWithdraw() {
    return withdraw;
  }

  public void setWithdraw(Set<WithdrawEntity> withdraw) {
    this.withdraw = withdraw;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }
}
