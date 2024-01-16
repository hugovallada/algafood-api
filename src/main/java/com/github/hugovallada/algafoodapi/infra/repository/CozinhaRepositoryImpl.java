package com.github.hugovallada.algafoodapi.infra.repository;

import com.github.hugovallada.algafoodapi.domain.model.Cozinha;
import com.github.hugovallada.algafoodapi.domain.repository.CozinhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
class CozinhaRepositoryImpl implements CozinhaRepository {

    private final EntityManager entityManager;

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
    public void remover(Long id) {
        final var cozinhaParaRemover = buscar(id);
        if (Objects.isNull(cozinhaParaRemover)) {
            throw new EmptyResultDataAccessException(1);
        }
        entityManager.remove(cozinhaParaRemover);
    }

}
