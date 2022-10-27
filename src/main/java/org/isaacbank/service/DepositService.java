package org.isaacbank.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.isaacbank.dto.DepositDTO;
import org.isaacbank.entity.DepositEntity;


@ApplicationScoped
public class DepositService {
  @Transactional
  public void depositar(DepositDTO dto) {
    DepositEntity deposit = new DepositEntity();
    deposit.setDescricao(dto.getDescricao());
    deposit.setValor(dto.getValor());
    deposit.setData(dto.getData());
    deposit.persist();
  }

  @Transactional
  public void modificar(Integer id, DepositDTO dto) {
    DepositEntity deposit = DepositEntity.findById(id);
    deposit.setDescricao(dto.getDescricao());
    deposit.setValor(dto.getValor());
    deposit.setData(dto.getData());
    deposit.persist();
  }

  @Transactional
  public void deletar(Integer id) {
    DepositEntity.deleteById(id);
  }

  public List<DepositEntity> listarDepositos() {
    return DepositEntity.listAll();
  }

  public DepositEntity buscarDeposito(Integer id) {
    return DepositEntity.findById(id);
  }

}
