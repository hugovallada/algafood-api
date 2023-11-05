package com.github.hugovallada.algafoodapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.hugovallada.algafoodapi.ports.Notificador;
import com.github.hugovallada.algafoodapi.services.AtivacaoCliente;

@Profile("exemplo-config")
@Configuration
public class AtivacaoClienteConfig {

    @Bean
    public AtivacaoCliente ativacaoCliente(Notificador notificador) {
        return new AtivacaoCliente(notificador);
    }

}
