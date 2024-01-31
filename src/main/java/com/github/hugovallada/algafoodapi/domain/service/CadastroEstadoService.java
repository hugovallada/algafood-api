package com.github.hugovallada.algafoodapi.domain.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.github.hugovallada.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.github.hugovallada.algafoodapi.domain.model.Estado;
import com.github.hugovallada.algafoodapi.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

    private final EstadoRepository<Estado> estadoRepository;

    public CadastroEstadoService(EstadoRepository<Estado> estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public Estado salvar(Estado estado) {
        return estadoRepository.salvar(estado);
    }

    public void deletar(Long estadoId) {
        final Estado estado = estadoRepository.buscar(estadoId);
        if (Objects.isNull(estado)) {
            throw new EntidadeNaoEncontradaException("Não encontrado");
        }
        estadoRepository.remover(estado);
    }

}
