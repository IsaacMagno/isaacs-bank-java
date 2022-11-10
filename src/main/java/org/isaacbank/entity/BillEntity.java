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
public class BillEntity extends PanacheEntityBase {
  @ManyToOne @JsonIgnore public AccountEntity account;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column private String nome;

  @Column private double valorTotal;

  @Column private double valorPago;

  @Column private double valorParcelas;

  @Column private int numeroParcelas;

  @Column private LocalDate dataInicio;

  @Column private LocalDate dataFinal;

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getValorParcelas() {
    return valorParcelas;
  }

  public void setValorParcelas(double valorParcelas) {
    this.valorParcelas = valorParcelas;
  }

  public int getNumeroParcelas() {
    return numeroParcelas;
  }

  public void setNumeroParcelas(int numeroParcelas) {
    this.numeroParcelas = numeroParcelas;
  }

  public LocalDate getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(LocalDate dataInicio) {
    this.dataInicio = dataInicio;
  }

  public LocalDate getDataFinal() {
    return dataFinal;
  }

  public void setDataFinal(LocalDate dataFinal) {
    this.dataFinal = dataFinal;
  }

  public AccountEntity getAccount() {
    return account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public double getValorPago() {
    return valorPago;
  }

  public void setValorPago(double valorPago) {
    this.valorPago += valorPago;
  }
}
