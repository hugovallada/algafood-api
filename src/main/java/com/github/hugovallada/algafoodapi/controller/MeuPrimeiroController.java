package com.github.hugovallada.algafoodapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.hugovallada.algafoodapi.models.Cliente;
import com.github.hugovallada.algafoodapi.services.AtivacaoCliente;

@RestController
public class MeuPrimeiroController {

    private AtivacaoCliente ativacaoCliente;

    public MeuPrimeiroController(AtivacaoCliente ativacaoCliente) {
        this.ativacaoCliente = ativacaoCliente;
    }

    @GetMapping("/hello")
    @ResponseBody
    String hello() {
        final var cliente = new Cliente("Hugo", "hugo.lopes@example.com", "323939993");
        ativacaoCliente.ativar(cliente);
        return cliente.getNome();
    }

}
