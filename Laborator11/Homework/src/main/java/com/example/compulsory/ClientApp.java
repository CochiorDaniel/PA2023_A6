package com.example.compulsory;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@SpringBootApplication
public class ClientApp {
    RestTemplate restTemplate = new RestTemplate();
    private static String url = "http://localhost:8080/home";
    private static HttpHeaders headers = new HttpHeaders();
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    public void getPlayers() {
        List<Player> players = restTemplate.getForObject(url, List.class);
        System.out.println("Players: " + players);
    }

    public void addPlayer(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>("{\"name\":\"Daniel\"}", headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        System.out.println("Response: " + response);
    }


    public void modifyPlayer(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>("{\"id\":\"0\",\"name\":\"Grigore\"}", headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println("Response: " + response);
    }

    public void deletePlayer(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>("{\"id\":\"0\"}", headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println("Response: " + response);
    }


}

