package com.github.hugovallada.algafoodapi.test;

import com.github.hugovallada.algafoodapi.DemoApplication;
import com.github.hugovallada.algafoodapi.domain.model.Cozinha;
import com.github.hugovallada.algafoodapi.domain.model.Restaurante;
import com.github.hugovallada.algafoodapi.domain.repository.CozinhaRepository;
import com.github.hugovallada.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ApplicationContext springContext = new SpringApplicationBuilder(DemoApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        final var cadastroCozinha = springContext.getBean(CozinhaRepository.class);

        final var retornoCozinha = cadastroCozinha.salvar(new Cozinha(null, "Baiana"));
        System.out.println(retornoCozinha.getId());
        cadastroCozinha.listar().forEach(cozinha -> System.out.println(cozinha.getNome()));

        final var cozinha2 = cadastroCozinha.buscar(2L);
        cozinha2.setNome("Brasileira");
        cadastroCozinha.salvar(cozinha2);
        cadastroCozinha.listar().forEach(cozinha -> System.out.println(cozinha.getNome()));
        cadastroCozinha.remover(cozinha2);
        cadastroCozinha.listar().forEach(cozinha -> System.out.println(cozinha.getNome()));
        final var cozinha1 = cadastroCozinha.buscar(1L);

        System.out.println("O valor recursivo é " + recursive("7"));

        System.out.println("Consulta RESTAURANTE:");
        final var restaurante = springContext.getBean(RestauranteRepository.class);
        final var newRestaurante = new Restaurante(null, "Oba", BigDecimal.TEN, cozinha1);
        restaurante.salvar(newRestaurante);
        restaurante.listar().forEach(r -> System.out.println(r.getNome() + " - " + r.getCozinha().getNome()));

        System.out.println(restaurante.buscar(1L));


    }

    private static String recursive(String value) {
        if (value.equals("1")) {
            return recursive("2");
        } else if (value.equals("2")) {
            return recursive("3");
        } else if (value.equals("3")) {
            return recursive("4");
        } else if (Integer.parseInt(value) > 5) {
            return recursive("1");
        } else {
            return value;
        }
    }
}
