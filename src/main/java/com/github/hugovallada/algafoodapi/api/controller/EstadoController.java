package com.github.hugovallada.algafoodapi.api.controller;

import com.github.hugovallada.algafoodapi.domain.model.Estado;
import com.github.hugovallada.algafoodapi.domain.repository.EstadoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoRepository<Estado> estadoRepository;

    public EstadoController(EstadoRepository<Estado> estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @GetMapping
    List<Estado> listar() {
        return estadoRepository.listar();
    }
}
