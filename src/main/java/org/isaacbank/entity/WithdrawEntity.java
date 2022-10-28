package org.isaacbank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class WithdrawEntity extends PanacheEntityBase {
  @ManyToOne
  @JsonIgnore
  public AccountEntity account;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "withdrawId")
  private Integer id;
  @Column
  private String descricao;

  @Column
  private double valor;

  @Column
  private LocalDate data;

  public Integer getId() {
    return id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public AccountEntity getAccount() {
    return account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }
}
