package com.github.hugovallada.algafoodapi.infra.repository;

import com.github.hugovallada.algafoodapi.domain.model.Restaurante;
import com.github.hugovallada.algafoodapi.domain.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class RestauranteRepositoryImpl implements RestauranteRepository {

    private final EntityManager entityManager;

    @Override
    public List<Restaurante> listar() {
        return entityManager.createQuery("from Restaurante", Restaurante.class).getResultList();
    }

    @Override
    public Restaurante buscar(Long id) {
        return entityManager.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public Restaurante salvar(Restaurante restaurante) {
        return entityManager.merge(restaurante);
    }

    @Transactional
    @Override
    public void remover(Restaurante restaurante) {
        entityManager.remove(restaurante);
    }
}
