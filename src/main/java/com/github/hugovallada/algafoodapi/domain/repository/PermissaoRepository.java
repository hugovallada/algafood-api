package com.github.hugovallada.algafoodapi.domain.repository;

import java.util.List;

public interface PermissaoRepository<T> {
    List<T> listar();

    T buscar(Long id);

    T salvar(T permissao);

    void remover(T permissao);
}
