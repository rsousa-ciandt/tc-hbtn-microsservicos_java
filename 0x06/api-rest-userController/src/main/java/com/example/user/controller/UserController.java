package com.example.user.controller;

import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("user-id/{id}")
    public ResponseEntity<String> findUserById(@PathVariable int id) {
        if (id <= 0 || id >= 100) {
            throw new UserIdException("You have entered invalid ID");
        }

        return ResponseEntity.ok("You have entered valid ID");
    }

    @GetMapping("user-cpf/{cpf}")
    public ResponseEntity<String> findUserByCPF(@PathVariable String cpf) {
        int cpfLength = cpf.length();

        if (cpfLength <= 3 || cpfLength >= 15) {
            throw new UserNameException("You have entered invalid CPF");
        }

        return ResponseEntity.ok("You have entered valid CPF");
    }

    @GetMapping("user-name/{userName}")
    public ResponseEntity<String> findUserByName(@PathVariable String userName) {
        int userNameLength = userName.length();

        if (userNameLength <= 3 || userNameLength >= 15) {
            throw new UserNameException("You have entered invalid USERNAME");
        }

        return ResponseEntity.ok("You have entered valid USERNAME");
    }

}
