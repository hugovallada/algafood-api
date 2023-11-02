package com.github.hugovallada.algafoodapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeuPrimeiroController {

    @GetMapping("/hello")
    @ResponseBody
    String hello() {
        System.out.println("Ola, tudo bom?");
        return "hello";
    }

}
