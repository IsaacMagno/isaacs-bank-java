package org.isaacbank.dto;

import java.time.LocalDate;

public class BillDTO {
  private String nome;

  private double valor;

  private double valorParcelas;

  private int numeroParcelas;

  private LocalDate dataInicio;

  private LocalDate dataFinal;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
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
}
