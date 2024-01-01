package com.github.hugovallada.algafoodapi.domain.repository;

import java.util.List;

import com.github.hugovallada.algafoodapi.domain.model.Cozinha;

public interface CozinhaRepository {
    
    List<Cozinha> listar();
    Cozinha buscar(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Cozinha cozinha);

}
