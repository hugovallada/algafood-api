package com.github.hugovallada.algafoodapi.services;

import org.springframework.stereotype.Component;

import com.github.hugovallada.algafoodapi.models.Cliente;
import com.github.hugovallada.algafoodapi.ports.Notificador;

@Component
public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do email %s: %s%n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}
