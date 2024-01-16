package com.github.hugovallada.algafoodapi.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.github.hugovallada.algafoodapi.domain.model.Cozinha;

import java.util.List;

@JsonRootName("cozinhas")
@JacksonXmlRootElement(localName = "cozis")
public record Cozinhas(
        @JsonProperty("cozinha")
        @JacksonXmlElementWrapper(useWrapping = false) // qnd tratar com lista, desabilitar o embrulo
        List<Cozinha> data
) {
}
