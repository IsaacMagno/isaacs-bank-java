package org.isaacbank.service;

import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.isaacbank.dto.BillDTO;
import org.isaacbank.entity.AccountEntity;
import org.isaacbank.entity.BillEntity;

@ApplicationScoped
public class BillService {

  @Transactional
  public void adicionarConta(BillDTO dto) {
    AccountEntity account = AccountEntity.findById(1);

    double valorParcelas = calcularParcelas(dto.getValor(),
        dto.getNumeroParcelas());

    BillEntity bill = new BillEntity();
    bill.setNome(dto.getNome());
    bill.setValor(dto.getValor());
    bill.setValorParcelas(valorParcelas);
    bill.setNumeroParcelas(dto.getNumeroParcelas());
    bill.setDataInicio(LocalDate.now());
    bill.setDataFinal(LocalDate.now().plusMonths(dto.getNumeroParcelas()));
    bill.setAccount(account);
    bill.persist();

    account.bills.add(bill);
    account.persist();
  }

  @Transactional
  public void atualizarConta(Integer id, BillDTO dto) {
    BillEntity oldBill = BillEntity.findById(id);

    double valorParcelas = calcularParcelas(dto.getValor(),
        dto.getNumeroParcelas());

    BillEntity bill = BillEntity.findById(id);
    bill.setNome(dto.getNome());
    bill.setValor(dto.getValor());
    bill.setValorParcelas(valorParcelas);
    bill.setNumeroParcelas(dto.getNumeroParcelas());
    bill.setDataInicio(oldBill.getDataInicio());
    bill.setDataFinal(oldBill.getDataInicio().plusMonths(dto.getNumeroParcelas()));
    bill.persist();
  }

  @Transactional
  public void deletar(Integer id) {
    BillEntity bill = BillEntity.findById(id);
    if (bill != null) {
      bill.account.bills.remove(bill);
      bill.delete();
    }
  }

  public List<BillEntity> listarContas() {
    return BillEntity.listAll();
  }

  public BillEntity selecionarConta(Integer id) {
    return BillEntity.findById(id);
  }


  public double calcularParcelas(double valor, int parcelas) {
    return  valor / parcelas;
  }

}
