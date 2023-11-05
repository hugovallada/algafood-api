package com.github.hugovallada.algafoodapi.services;

import org.springframework.stereotype.Component;

import com.github.hugovallada.algafoodapi.models.Cliente;

@Component
public class AtivacaoCliente {

    private NotificadorEmail notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();
        notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
    }

}
