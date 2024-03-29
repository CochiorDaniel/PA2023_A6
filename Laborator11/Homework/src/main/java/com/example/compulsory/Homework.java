package com.example.compulsory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class Homework {

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(Homework.class, args);
        sleep(1000);
        ClientApp clientApp = new ClientApp();
        clientApp.getPlayers();

    }



}
