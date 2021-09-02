package com.example.mesttra.secretariat.controller;

import com.example.mesttra.secretariat.model.Secretariat;
import com.example.mesttra.secretariat.service.SecretariatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secretariats")
public class SecretariatController {

    SecretariatService secretariatService;

    public SecretariatController(SecretariatService secretariatService) { this.secretariatService = secretariatService; }

    @GetMapping
    public List<Secretariat> listSecretariats() { return this.secretariatService.listSecretariats(); }

}
