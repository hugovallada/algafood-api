package com.github.hugovallada.algafoodapi.services;

import static com.github.hugovallada.algafoodapi.util.annotations.helpers.NivelUrgencia.NORMAL;

import org.springframework.stereotype.Component;

import com.github.hugovallada.algafoodapi.models.Cliente;
import com.github.hugovallada.algafoodapi.ports.Notificador;
import com.github.hugovallada.algafoodapi.util.annotations.TipoDoNotificador;

@Component
@TipoDoNotificador(NORMAL)
public class NotificadorSMS implements Notificador {
    @Override
    public void notificar(Cliente cliente, String mensagem) {

        System.out.printf("Notificando %s por SMS através do telefone %s: %s%n",
                cliente.getNome(), cliente.getTelefone(), mensagem);
    }
}
