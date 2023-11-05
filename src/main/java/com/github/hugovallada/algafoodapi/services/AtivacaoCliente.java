package com.github.hugovallada.algafoodapi.services;

import org.springframework.stereotype.Component;

import com.github.hugovallada.algafoodapi.models.Cliente;
import com.github.hugovallada.algafoodapi.ports.Notificador;

@Component
public class AtivacaoCliente {

    private Notificador notificador;

    public AtivacaoCliente(Notificador notificador) {
        this.notificador = notificador;
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();
        notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
    }

}
