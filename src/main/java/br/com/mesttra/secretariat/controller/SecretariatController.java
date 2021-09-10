package br.com.mesttra.secretariat.controller;

import br.com.mesttra.secretariat.model.Secretariat;
import br.com.mesttra.secretariat.service.SecretariatService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/secretariats")
public class SecretariatController {

    SecretariatService secretariatService;

    public SecretariatController(SecretariatService secretariatService) { this.secretariatService = secretariatService; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Secretariat addSecretariat(@Valid @RequestBody Secretariat secretariat) { return secretariatService.addSecretariat(secretariat); }

    @GetMapping
    public List<Secretariat> listSecretariats() { return this.secretariatService.listSecretariats(); }

}
