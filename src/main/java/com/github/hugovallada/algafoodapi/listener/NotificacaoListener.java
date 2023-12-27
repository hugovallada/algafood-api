package com.github.hugovallada.algafoodapi.listener;

import com.github.hugovallada.algafoodapi.event.ClienteAtivadoEvent;
import com.github.hugovallada.algafoodapi.ports.Notificador;
import com.github.hugovallada.algafoodapi.util.annotations.TipoDoNotificador;
import com.github.hugovallada.algafoodapi.util.annotations.helpers.NivelUrgencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoListener {

    @Autowired
    @TipoDoNotificador(NivelUrgencia.NORMAL)
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        System.out.println("Cliente " + event.cliente().getNome() + " agora está ativo");
        notificador.notificar(event.cliente(), "Seu cadastro no sistema está ativo");
    }

}
