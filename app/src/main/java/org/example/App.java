/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;


import org.example.auth.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.example.repository"})
@ComponentScan(basePackages = {"org.example.controller", "org.example.auth", "org.example..service"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}