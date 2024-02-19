package com.github.hugovallada.algafoodapi.domain.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hugovallada.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.github.hugovallada.algafoodapi.domain.model.Cozinha;
import com.github.hugovallada.algafoodapi.domain.model.Restaurante;
import com.github.hugovallada.algafoodapi.domain.repository.CozinhaRepository;
import com.github.hugovallada.algafoodapi.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        final Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
        if (Objects.isNull(cozinha)) {
            throw new EntidadeNaoEncontradaException("Não existe cozinha para o código" + cozinhaId);
        }
       return restauranteRepository.salvar(restaurante);
    }

}
