package org.isaacbank.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.isaacbank.dto.FutureExpensesDTO;
import org.isaacbank.entity.AccountEntity;
import org.isaacbank.entity.FutureExpensesEntity;

@ApplicationScoped
public class FutureExpensesService {
  public List<FutureExpensesEntity> listarDespesasFuturas() {
    return FutureExpensesEntity.listAll();
  }

  public FutureExpensesEntity selecionarDespesa(Integer id) {
    return FutureExpensesEntity.findById(id);
  }

  @Transactional
  public void adicionarDespesa(FutureExpensesDTO dto) {
    AccountEntity account = AccountEntity.findById(1);

    FutureExpensesEntity expense = new FutureExpensesEntity();
    expense.setNome(dto.getNome());
    expense.setCategoria(dto.getCategoria());
    expense.setDescricao(dto.getDescricao());
    expense.setValor(dto.getValor());
    expense.setAccount(account);
    expense.persist();

    account.expenses.add(expense);
    account.persist();
  }

  @Transactional
  public void atualizarDespesa(Integer id, FutureExpensesDTO dto) {
    FutureExpensesEntity expense = FutureExpensesEntity.findById(id);
    expense.setNome(dto.getNome());
    expense.setCategoria(dto.getCategoria());
    expense.setDescricao(dto.getDescricao());
    expense.setValor(dto.getValor());
    expense.persist();
  }

  @Transactional
  public void deletar(Integer id) {
    FutureExpensesEntity.deleteById(id);
  }
}
