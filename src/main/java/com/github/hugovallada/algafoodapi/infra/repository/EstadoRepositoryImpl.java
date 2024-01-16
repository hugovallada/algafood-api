package com.github.hugovallada.algafoodapi.infra.repository;

import com.github.hugovallada.algafoodapi.domain.model.Estado;
import com.github.hugovallada.algafoodapi.domain.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public Estado salvar(Estado estado) {
        return entityManager.merge(estado);
    }

    @Override
    public void remover(Estado estado) {
        entityManager.remove(estado);
    }
}
