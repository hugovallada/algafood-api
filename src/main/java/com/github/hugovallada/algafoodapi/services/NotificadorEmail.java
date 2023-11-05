package com.github.hugovallada.algafoodapi.services;

import static com.github.hugovallada.algafoodapi.util.annotations.helpers.NivelUrgencia.URGENTE;

import org.springframework.stereotype.Component;

import com.github.hugovallada.algafoodapi.models.Cliente;
import com.github.hugovallada.algafoodapi.ports.Notificador;
import com.github.hugovallada.algafoodapi.util.annotations.TipoDoNotificador;

@Component
@TipoDoNotificador(URGENTE)
public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {

        System.out.printf("Notificando %s através do email %s: %s%n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}
