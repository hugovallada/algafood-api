package com.github.hugovallada.algafoodapi.domain.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.github.hugovallada.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.github.hugovallada.algafoodapi.domain.model.Cidade;
import com.github.hugovallada.algafoodapi.domain.model.Estado;
import com.github.hugovallada.algafoodapi.domain.repository.CidadeRepository;
import com.github.hugovallada.algafoodapi.domain.repository.EstadoRepository;

import lombok.val;

@Service
public class CadastroCidadeService {

    private final CidadeRepository<Cidade> cidadeRepository;
    private final EstadoRepository<Estado> estadoRepository;

    public CadastroCidadeService(CidadeRepository<Cidade> cidadeRepository, EstadoRepository<Estado> estadoRepository) {
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
    }

    public Cidade salvar(Cidade cidade) {
        final Long estadoId = cidade.getEstado().getId();
        val estado = estadoRepository.buscar(estadoId);
        if (estado == null) {
            throw new EntidadeNaoEncontradaException("Estado não encontrado");
        }
        cidade.setEstado(estado);
        return cidadeRepository.salvar(cidade);
    }

    public void excluir(Long cidadeId) {
        val cidade = cidadeRepository.buscar(cidadeId);
        if (Objects.isNull(cidade)) {
            throw new EntidadeNaoEncontradaException("Cidade não encontrada");
        }
        cidadeRepository.remover(cidade);
    }

}
