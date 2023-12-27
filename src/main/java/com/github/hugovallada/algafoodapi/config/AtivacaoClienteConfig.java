package com.github.hugovallada.algafoodapi.config;

import com.github.hugovallada.algafoodapi.services.AtivacaoCliente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("config-example")
@Configuration
public class AtivacaoClienteConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public AtivacaoCliente ativacaoCliente() {
        return new AtivacaoCliente();
    }

}
