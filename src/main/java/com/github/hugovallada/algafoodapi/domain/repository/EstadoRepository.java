package com.github.hugovallada.algafoodapi.domain.repository;

import java.util.List;

public interface EstadoRepository<T> {
    List<T> listar();

    T buscar(Long id);

    T salvar(T estado);

    void remover(T estado);
}
