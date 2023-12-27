package com.github.hugovallada.algafoodapi.util.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import org.springframework.beans.factory.annotation.Qualifier;

import com.github.hugovallada.algafoodapi.util.annotations.helpers.NivelUrgencia;

@Retention(RUNTIME)
@Qualifier
public @interface TipoDoNotificador {

    NivelUrgencia value();

}
