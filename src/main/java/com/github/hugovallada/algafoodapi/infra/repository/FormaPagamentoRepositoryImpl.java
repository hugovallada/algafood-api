package com.github.hugovallada.algafoodapi.infra.repository;

import com.github.hugovallada.algafoodapi.domain.model.FormaPagamento;
import com.github.hugovallada.algafoodapi.domain.repository.FormaPagamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository<FormaPagamento> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FormaPagamento> listar() {
        return entityManager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
    }

    @Override
    public FormaPagamento buscar(Long id) {
        return entityManager.find(FormaPagamento.class, id);
    }

    @Override
    @Transactional
    public FormaPagamento salvar(FormaPagamento formaPagamento) {
        return entityManager.merge(formaPagamento);
    }

    @Override
    @Transactional
    public void remover(FormaPagamento formaPagamento) {
        entityManager.remove(formaPagamento);
    }
}
