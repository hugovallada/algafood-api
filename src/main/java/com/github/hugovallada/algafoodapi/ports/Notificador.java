package com.github.hugovallada.algafoodapi.ports;

import com.github.hugovallada.algafoodapi.models.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
