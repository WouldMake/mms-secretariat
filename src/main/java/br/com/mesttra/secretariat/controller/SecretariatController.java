package br.com.mesttra.secretariat.controller;

import br.com.mesttra.secretariat.exception.BusinessException;
import br.com.mesttra.secretariat.model.Secretariat;
import br.com.mesttra.secretariat.request.ChangeInvestigationRequest;
import br.com.mesttra.secretariat.service.SecretariatService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secretariats")
public class SecretariatController {

    SecretariatService secretariatService;

    public SecretariatController(SecretariatService secretariatService) { this.secretariatService = secretariatService; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Secretariat addSecretariat(@Valid @RequestBody Secretariat secretariat) { return this.secretariatService.addSecretariat(secretariat); }

    @GetMapping
    public List<Secretariat> listSecretariats() { return this.secretariatService.listSecretariats(); }

    @GetMapping("/{id}")
    public Optional<Secretariat> getSecretariat(@PathVariable Long id) { return this.secretariatService.getSecretariat(id); }

    @PatchMapping("{id}/investigation")
    public Secretariat changeInvestigation(@PathVariable Long id, @Valid @RequestBody ChangeInvestigationRequest changeInvestigationRequest) throws BusinessException {
        return this.secretariatService.changeInvestigation(id, changeInvestigationRequest);
    }
}
