package com.github.hugovallada.algafoodapi.services;

import org.springframework.stereotype.Component;

import com.github.hugovallada.algafoodapi.models.Cliente;
import com.github.hugovallada.algafoodapi.ports.Notificador;

@Component("sms")
public class NotificadorSMS implements Notificador {
    @Override
    public void notificar(Cliente cliente, String mensagem) {

        System.out.printf("Notificando %s por SMS através do telefone %s: %s%n",
                cliente.getNome(), cliente.getTelefone(), mensagem);
    }
}
