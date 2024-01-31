package com.github.hugovallada.algafoodapi.infra.repository;

import com.github.hugovallada.algafoodapi.domain.model.Cidade;
import com.github.hugovallada.algafoodapi.domain.repository.CidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class CidadeRepositoryImpl implements CidadeRepository<Cidade> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cidade> listar() {
        return entityManager.createQuery("from Cidade", Cidade.class).getResultList();
    }

    @Override
    public Cidade buscar(Long id) {
        return entityManager.find(Cidade.class, id);
    }

    @Override
    @Transactional
    public Cidade salvar(Cidade cidade) {
        return entityManager.merge(cidade);
    }

    @Override
    @Transactional
    public void remover(Cidade cidade) {
        entityManager.remove(cidade);
    }
}
