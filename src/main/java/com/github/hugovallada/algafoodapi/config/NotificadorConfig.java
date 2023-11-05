package com.github.hugovallada.algafoodapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.hugovallada.algafoodapi.ports.Notificador;
import com.github.hugovallada.algafoodapi.services.NotificadorEmail;

@Profile("exemplo-config")
@Configuration
public class NotificadorConfig {

    @Bean
    public Notificador notificador() {
        NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com");
        notificador.setCaixaAlta(true);
        return notificador;
    }

}
