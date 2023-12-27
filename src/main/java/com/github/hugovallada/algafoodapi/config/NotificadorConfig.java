package com.github.hugovallada.algafoodapi.config;

import com.github.hugovallada.algafoodapi.ports.Notificador;
import com.github.hugovallada.algafoodapi.services.NotificadorEmail;
import org.springframework.context.annotation.Bean;

//@Configuration
public class NotificadorConfig {

    @Bean
    public Notificador notificador() {
        NotificadorEmail notificador = new NotificadorEmail();
        //notificador.setCaixaAlta(true);
        return notificador;
    }

}
