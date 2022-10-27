package org.isaacbank.service;

import org.isaacbank.dto.WithdrawDTO;
import org.isaacbank.entity.WithdrawEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class WithdrawService {
  @Transactional
  public void sacar(WithdrawDTO dto) {
    WithdrawEntity withdraw = new WithdrawEntity();
    withdraw.setDescricao(dto.getDescricao());
    withdraw.setValor(dto.getValor());
    withdraw.setData(dto.getData());
    withdraw.persist();
  }

  @Transactional
  public void modificar(Integer id, WithdrawDTO dto) {
    WithdrawEntity withdraw = WithdrawEntity.findById(id);
    withdraw.setDescricao(dto.getDescricao());
    withdraw.setValor(dto.getValor());
    withdraw.setData(dto.getData());
    withdraw.persist();
  }

  @Transactional
  public void deletar(Integer id) {
    WithdrawEntity.deleteById(id);
  }

  public List<WithdrawEntity> listarSaques() {
    return WithdrawEntity.listAll();
  }

  public WithdrawEntity buscarSaque(Integer id) {
    return WithdrawEntity.findById(id);
  }
}
