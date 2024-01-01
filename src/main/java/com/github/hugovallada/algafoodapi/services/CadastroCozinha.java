package com.github.hugovallada.algafoodapi.services;

import com.github.hugovallada.algafoodapi.domain.model.Cozinha;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Cozinha> listar() {
        var query = entityManager.createQuery("from Cozinha", Cozinha.class);
        return query.getResultList();
    }

    public Cozinha buscaPorId(Long id) {
        return entityManager.find(Cozinha.class, id);
    }

    @Transactional
    public Cozinha adicionar(Cozinha cozinha) {
        entityManager.merge(cozinha);
        return cozinha;
    }

    @Transactional
    public void remover(Cozinha cozinha) {
        final var cozinhaParaRemover = buscaPorId(cozinha.getId());
        entityManager.remove(cozinhaParaRemover);
    }
}
