package com.github.hugovallada.algafoodapi.services;

import com.github.hugovallada.algafoodapi.event.ClienteAtivadoEvent;
import com.github.hugovallada.algafoodapi.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoCliente {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void ativar(Cliente cliente) {
        cliente.ativar();
        publisher.publishEvent(new ClienteAtivadoEvent(cliente));
    }

}
