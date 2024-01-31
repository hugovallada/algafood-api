package com.github.hugovallada.algafoodapi.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.hugovallada.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.github.hugovallada.algafoodapi.domain.model.Estado;
import com.github.hugovallada.algafoodapi.domain.repository.EstadoRepository;
import com.github.hugovallada.algafoodapi.domain.service.CadastroEstadoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoRepository<Estado> estadoRepository;
    private final CadastroEstadoService cadastroEstadoService;

    @GetMapping("/{estadoId}")
    ResponseEntity<Estado> buscar(@PathVariable Long estadoId) {
        final Estado estado = estadoRepository.buscar(estadoId);
        if (estado != null) {
            return ResponseEntity.ok(estado);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Estado adicionar(@RequestBody Estado estado) {
        return cadastroEstadoService.salvar(estado);
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId,
            @RequestBody Estado estado) {
        Estado estadoAtual = estadoRepository.buscar(estadoId);

        if (estadoAtual != null) {
            BeanUtils.copyProperties(estado, estadoAtual, "id");

            estadoAtual = cadastroEstadoService.salvar(estadoAtual);
            return ResponseEntity.ok(estadoAtual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<?> remover(@PathVariable Long estadoId) {
        try {
            cadastroEstadoService.deletar(estadoId);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    List<Estado> listar() {
        return estadoRepository.listar();
    }
}
