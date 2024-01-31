package com.github.hugovallada.algafoodapi.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hugovallada.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.github.hugovallada.algafoodapi.domain.model.Restaurante;
import com.github.hugovallada.algafoodapi.domain.repository.RestauranteRepository;
import com.github.hugovallada.algafoodapi.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final RestauranteRepository restauranteRepository;
    private final CadastroRestauranteService cadastroRestauranteService;

    public RestauranteController(RestauranteRepository restauranteRepository,
            CadastroRestauranteService cadastroRestauranteService) {
        this.restauranteRepository = restauranteRepository;
        this.cadastroRestauranteService = cadastroRestauranteService;
    }

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteRepository.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscaPorId(@RequestParam Long id) {
        final var restaurante = restauranteRepository.buscar(id);
        if (Objects.isNull(restaurante)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurante);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Restaurante> criar(@RequestBody Restaurante restaurante) {
        try {
            restaurante = cadastroRestauranteService.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(restaurante);
        } catch (EntidadeNaoEncontradaException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        final Restaurante restauranteExistente = restauranteRepository.buscar(id);
        if (Objects.isNull(restauranteExistente)) {
            return ResponseEntity.notFound().build();
        }
        try {
            BeanUtils.copyProperties(restaurante, restauranteExistente, "id");
            cadastroRestauranteService.salvar(restaurante);
            return ResponseEntity.accepted().build();
        } catch (EntidadeNaoEncontradaException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{restauranteId}")
    ResponseEntity<?> atualizarParcial(
            @PathVariable Long restauranteId,
            @RequestBody Map<String, Object> campos) {
        final var restauranteAtual = restauranteRepository.buscar(restauranteId);
        if (restauranteAtual == null) {
            return ResponseEntity.notFound().build();
        }
        merge(campos, restauranteAtual);
        return atualizar(restauranteId, restauranteAtual);
    }

    private void merge(Map<String, Object> campos, Restaurante restauranteDestino) {
        ObjectMapper om = new ObjectMapper();
        Restaurante restauranteOrigen = om.convertValue(campos, Restaurante.class);
        campos.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade); // busca o field pelo nome
            field.setAccessible(true);
            Object novoValor = ReflectionUtils.getField(field, restauranteOrigen);
            ReflectionUtils.setField(field, restauranteDestino, novoValor); // seta um novo valor para o field
            field.setAccessible(false);
        });
    }

}
