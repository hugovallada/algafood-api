package com.github.hugovallada.algafoodapi.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class UseCaseAsync {

    @Async
    public void execute() {
        try {
            System.out.println("Iniciando chamada na thread " + Thread.currentThread().getName());
            Thread.sleep(10000);
            var client = HttpClient.newBuilder()
                    .build();
            var request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI("https://viacep.com.br/ws/14010090/json/"))
                    .build();
            var bodyHandler = HttpResponse.BodyHandlers.ofString();
            var response = client.send(request, bodyHandler);
            System.out.println(response.body());
            System.out.println("Finalizando chamada " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


}
