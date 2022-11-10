package org.isaacbank.service;

import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.isaacbank.dto.BillDTO;
import org.isaacbank.entity.AccountEntity;
import org.isaacbank.entity.BillEntity;
import org.isaacbank.entity.WithdrawEntity;

@ApplicationScoped
public class BillService {

  @Transactional
  public void adicionarConta(BillDTO dto) {
    AccountEntity account = AccountEntity.findById(1);

    double valorParcelas = calcularParcelas(dto.getValorTotal(), dto.getNumeroParcelas());

    BillEntity bill = new BillEntity();
    bill.setNome(dto.getNome());
    bill.setValorTotal(dto.getValorTotal());
    bill.setValorPago(0d);
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
    AccountEntity account = AccountEntity.findById(1);
    WithdrawEntity withdraw = new WithdrawEntity();
    BillEntity bill = BillEntity.findById(id);

    bill.setValorPago(dto.getValorPago());
    bill.persist();

    withdraw.setDescricao(bill.getNome());
    withdraw.setCategoria("Contas");
    withdraw.setValor(dto.getValorPago());
    withdraw.setData(LocalDate.now());
    withdraw.setAccount(account);
    withdraw.persist();

    account.withdrawals.add(withdraw);
    account.setSaldo(-dto.getValorPago());
    account.persist();
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
    return valor / parcelas;
  }
}
