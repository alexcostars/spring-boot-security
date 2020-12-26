package com.alexcosta.seguranca.controllers;

import java.util.List;
import com.alexcosta.seguranca.models.UserModel;
import com.alexcosta.seguranca.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsuarioController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    @ResponseBody
    public List<UserModel> mostrarUsuarios() {
        return this.userRepository.findAll();
    }

    @GetMapping("/password-generator")
    @ResponseBody
    public String passwordGenerator() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder.encode("123");
    }

    @GetMapping("/entrar")
    public String login() {
        return "login";
    }
}
