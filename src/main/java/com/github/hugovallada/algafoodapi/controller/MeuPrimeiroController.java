package com.github.hugovallada.algafoodapi.controller;

import com.github.hugovallada.algafoodapi.models.Cliente;
import com.github.hugovallada.algafoodapi.services.AtivacaoCliente;
import com.github.hugovallada.algafoodapi.services.UseCaseAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class MeuPrimeiroController {

    private final AtivacaoCliente ativacaoCliente;

    @Autowired
    private UseCaseAsync useCaseAsync;

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

    @GetMapping("/async")
    @ResponseStatus(HttpStatus.OK)
    void async() {
        System.out.println(Thread.currentThread().getName());
        CompletableFuture.runAsync(() -> useCaseAsync.execute());
    }

}
