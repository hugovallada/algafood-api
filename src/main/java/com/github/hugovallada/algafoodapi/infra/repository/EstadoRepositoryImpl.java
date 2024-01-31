package com.github.hugovallada.algafoodapi.infra.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.hugovallada.algafoodapi.domain.model.Estado;
import com.github.hugovallada.algafoodapi.domain.repository.EstadoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
class EstadoRepositoryImpl implements EstadoRepository<Estado> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Estado> listar() {
        return entityManager.createQuery("from Estado", Estado.class).getResultList();
    }

    @Override
    public Estado buscar(Long id) {
        return entityManager.find(Estado.class, id);
    }

    @Override
    @Transactional
    public Estado salvar(Estado estado) {
        return entityManager.merge(estado);
    }

    @Override
    @Transactional
    public void remover(Estado estado) {
        entityManager.remove(estado);
    }
}
