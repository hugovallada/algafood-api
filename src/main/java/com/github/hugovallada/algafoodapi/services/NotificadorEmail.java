package com.github.hugovallada.algafoodapi.services;

import com.github.hugovallada.algafoodapi.config.NotificadorConfigProperties;
import com.github.hugovallada.algafoodapi.models.Cliente;
import com.github.hugovallada.algafoodapi.ports.Notificador;
import com.github.hugovallada.algafoodapi.util.annotations.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.github.hugovallada.algafoodapi.util.annotations.helpers.NivelUrgencia.URGENTE;

@Component
@TipoDoNotificador(URGENTE)
public class NotificadorEmail implements Notificador {

    @Autowired
    private NotificadorConfigProperties properties;

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do email %s, no host %s:%d: %s%n",
                cliente.getNome(), cliente.getEmail(), properties.getHostServidor(), properties.getPortServidor(), mensagem);
    }

}
