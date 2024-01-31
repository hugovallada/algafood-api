package com.github.hugovallada.algafoodapi.api.controller;

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
import com.github.hugovallada.algafoodapi.domain.model.Cidade;
import com.github.hugovallada.algafoodapi.domain.repository.CidadeRepository;
import com.github.hugovallada.algafoodapi.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeRepository<Cidade> cidadeRepository;
    private final CadastroCidadeService cadastroCidadeService;

    public CidadeController(CidadeRepository<Cidade> cidadeRepository, CadastroCidadeService cadastroCidadeService) {
        this.cidadeRepository = cidadeRepository;
        this.cadastroCidadeService = cadastroCidadeService;
    }

    @GetMapping("/{cidadeId}")
    public ResponseEntity<?> buscar(@PathVariable Long cidadeId) {
        final var cidade = cidadeRepository.buscar(cidadeId);
        return ResponseEntity
                .status(cidade != null ? 200 : 500)
                .body(cidade);
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(cadastroCidadeService.salvar(cidade));
        } catch (EntidadeNaoEncontradaException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/cidadeId")
    public ResponseEntity<Cidade> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
        Cidade cidadeAtual = cidadeRepository.buscar(cidadeId);
        if (cidadeAtual != null) {
            BeanUtils.copyProperties(cidade, cidadeAtual, "id");
            cidadeAtual = cadastroCidadeService.salvar(cidadeAtual);
            return ResponseEntity.ok(cidadeAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/cidadeId")
    public ResponseEntity<?> remover(@PathVariable Long cidadeId) {
        try {
            cadastroCidadeService.excluir(cidadeId);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
