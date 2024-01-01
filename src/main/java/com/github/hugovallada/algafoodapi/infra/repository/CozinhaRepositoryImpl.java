package com.github.hugovallada.algafoodapi.infra.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.hugovallada.algafoodapi.domain.model.Cozinha;
import com.github.hugovallada.algafoodapi.domain.repository.CozinhaRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepository {

    private EntityManager entityManager;

    public CozinhaRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Cozinha> listar() {
        var query = entityManager.createQuery("from Cozinha", Cozinha.class);
        return query.getResultList();
    }

    @Override
    public Cozinha buscar(Long id) {
        return entityManager.find(Cozinha.class, id);
    }

    @Override
    @Transactional
    public Cozinha salvar(Cozinha cozinha) {
        entityManager.merge(cozinha);
        return cozinha;
    }

    @Override
    @Transactional
    public void remover(Cozinha cozinha) {
        final var cozinhaParaRemover = buscar(cozinha.getId());
        entityManager.remove(cozinhaParaRemover);
    }

}
