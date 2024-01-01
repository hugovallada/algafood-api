package com.github.hugovallada.algafoodapi.domain.repository;

import java.util.List;

public interface FormaPagamentoRepository<T> {
    List<T> listar();

    T buscar(Long id);

    T salvar(T formaPagamento);

    void remover(T formaPagamento);
}
