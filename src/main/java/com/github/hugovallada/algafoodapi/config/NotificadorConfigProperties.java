package com.github.hugovallada.algafoodapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "notificador.email")
public class NotificadorConfigProperties {
    private String hostServidor;
    private int portServidor;

    public String getHostServidor() {
        return hostServidor;
    }

    public void setHostServidor(String hostServidor) {
        this.hostServidor = hostServidor;
    }

    public int getPortServidor() {
        return portServidor;
    }

    public void setPortServidor(int portServidor) {
        this.portServidor = portServidor;
    }
}
