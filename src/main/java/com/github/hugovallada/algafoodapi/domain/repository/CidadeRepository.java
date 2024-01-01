package com.github.hugovallada.algafoodapi.domain.repository;

import java.util.List;

public interface CidadeRepository<T> {
    List<T> listar();

    T buscar(Long id);

    T salvar(T cidade);

    void remover(T cidade);
}
