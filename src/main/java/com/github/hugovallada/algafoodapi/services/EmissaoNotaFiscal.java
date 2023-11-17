package com.github.hugovallada.algafoodapi.services;

import com.github.hugovallada.algafoodapi.event.ClienteAtivadoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmissaoNotaFiscal {

    @EventListener
    public void emitirNotaFiscal(ClienteAtivadoEvent event) {
        System.out.println("Emitindo nota fiscal para o cliente " + event.cliente().getNome());
    }
}
