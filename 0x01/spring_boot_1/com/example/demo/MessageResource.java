package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageResource {

    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
    }

    @GetMapping("/login/{user}/{password}")
    public String login(@PathVariable String user, @PathVariable String password) {
        int minLength = 15;

        boolean isBlank = user.isBlank() || password.isBlank();
        boolean hasMinLength = user.length() >= minLength || password.length() >= minLength;

        String message;

        if (isBlank) {
            message = "USUÁRIO E SENHA NÃO INFORMADOS";
        } else if (!hasMinLength) {
            message = "USUÁRIO E SENHA INVÁLIDOS";
        } else {
            message = "LOGIN EFETUADO COM SUCESSO !!!";
        }

        return message;
    }
}
