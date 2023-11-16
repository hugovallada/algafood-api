package com.github.hugovallada.algafoodapi.services;

import com.github.hugovallada.algafoodapi.models.Cliente;
import com.github.hugovallada.algafoodapi.ports.Notificador;
import com.github.hugovallada.algafoodapi.util.annotations.TipoDoNotificador;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.github.hugovallada.algafoodapi.util.annotations.helpers.NivelUrgencia.URGENTE;

@Component
public class AtivacaoCliente {

    // @Autowired(required = false) -> Diz q a dependencia não é obrigatória
    private final Notificador notificador;

    // private List<Notificador> notificadores;

    // @Autowired // caso tenha mais de um construtor, o @Autowired define qual
    // construtor o Spring vai usar
    // O ideal é injetar via construtor
    // É possível fazer dependencia opcional no construtor, desde q o @Autowired
    // esteja no parametro

    public AtivacaoCliente(@Autowired(required = false) @TipoDoNotificador(URGENTE) Notificador notificador) {
        this.notificador = notificador;
    }

    /**
     * public AtivacaoCliente(List<Notificador> notificadores) {
     * this.notificadores = notificadores;
     * }
     */

    @PostConstruct
    public void init() {
        System.out.println("INIT");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("DESTROY");
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
