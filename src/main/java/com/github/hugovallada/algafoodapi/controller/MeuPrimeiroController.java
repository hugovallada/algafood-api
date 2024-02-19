package com.github.hugovallada.algafoodapi.controller;

import com.github.hugovallada.algafoodapi.models.Cliente;
import com.github.hugovallada.algafoodapi.services.AtivacaoCliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeuPrimeiroController {

    private final AtivacaoCliente ativacaoCliente;

    public MeuPrimeiroController(AtivacaoCliente ativacaoCliente) {
        this.ativacaoCliente = ativacaoCliente;
    }

    @GetMapping("/hello")
    String hello() {
        final var cliente = new Cliente("Hugo", "hugo.lopes@example.com", "323939993");
        ativacaoCliente.ativar(cliente);
        return cliente.getNome();
    }

    @GetMapping("/ola")
    Response ola() {
        return new Response("Hugo", "28");
    }

}
