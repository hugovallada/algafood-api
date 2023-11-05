package com.github.hugovallada.algafoodapi.services;

import org.springframework.stereotype.Component;

import com.github.hugovallada.algafoodapi.models.Cliente;
import com.github.hugovallada.algafoodapi.ports.Notificador;

@Component
public class AtivacaoCliente {

    private Notificador notificador;

    // @Autowired // caso tenha mais de um construtor, o @Autowired define qual
    // construtor o Spring vai usar
    // O ideal é injetar via construtor
    public AtivacaoCliente(Notificador notificador) {
        this.notificador = notificador;
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();
        notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
    }
    /**
     * @Autowired // Pode usar o @Autowired para fazer a injeção via Setter
     *            public void setNotificador(Notificador notificador) {
     *            this.notificador = notificador;
     *            }
     */

}
