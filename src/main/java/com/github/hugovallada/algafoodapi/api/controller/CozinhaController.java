package com.github.hugovallada.algafoodapi.api.controller;

import com.github.hugovallada.algafoodapi.api.response.Cozinhas;
import com.github.hugovallada.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.github.hugovallada.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.github.hugovallada.algafoodapi.domain.model.Cozinha;
import com.github.hugovallada.algafoodapi.domain.repository.CozinhaRepository;
import com.github.hugovallada.algafoodapi.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/cozinhas")
class CozinhaController {

    private final CozinhaRepository cozinhaRepository;

    private final CadastroCozinhaService cadastroCozinhaService;

    public CozinhaController(CozinhaRepository cozinhaRepository, CadastroCozinhaService cadastroCozinhaService) {
        this.cozinhaRepository = cozinhaRepository;
        this.cadastroCozinhaService = cadastroCozinhaService;
    }

    @GetMapping
    Cozinhas listar() {
        return new Cozinhas(cozinhaRepository.listar());
    }

    @GetMapping("/{id}")
    ResponseEntity<Cozinha> buscar(@PathVariable("id") Long id) {
        final Cozinha cozinha = cozinhaRepository.buscar(id);
        //return ResponseEntity.ok(cozinha);


        //HttpHeaders headers = new HttpHeaders();
        //headers.add(HttpHeaders.LOCATION, "http://api.algafood.local:8080/cozinhas");

        if (Objects.isNull(cozinha)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cozinha);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void adicionar(Cozinha cozinha) {
        cadastroCozinhaService.salvar(cozinha);
    }

    @PutMapping("/{id}")
    ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha) {
        var cozinhaAtual = cozinhaRepository.buscar(id);
        if (Objects.isNull(cozinhaAtual)) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
        cozinhaAtual = cozinhaRepository.salvar(cozinhaAtual);
        return ResponseEntity.accepted().body(cozinhaAtual);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            cadastroCozinhaService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
