package br.com.mesttra.secretariat.controller;

import br.com.mesttra.secretariat.exception.BusinessException;
import br.com.mesttra.secretariat.model.Secretariat;
import br.com.mesttra.secretariat.request.ChangeInvestigationRequest;
import br.com.mesttra.secretariat.service.SecretariatService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Add secretariat",
            notes = "This method adds a new secretariat.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Secretariat added"),
            @ApiResponse(code = 500, message = "Internal Error"),
    })
    public Secretariat addSecretariat(@Valid @RequestBody Secretariat secretariat) { return this.secretariatService.addSecretariat(secretariat); }

    @GetMapping
    @ApiOperation(value = "List secretariats",
            notes = "This method lists all secretariats.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Secretariats listed"),
            @ApiResponse(code = 500, message = "Internal Error"),
    })
    public List<Secretariat> listSecretariats() { return this.secretariatService.listSecretariats(); }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find secretariat by id",
            notes = "This method finds a secretariat by its id and returns secretariat data.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Secretariat found"),
            @ApiResponse(code = 500, message = "Internal Error"),
    })
    public Optional<Secretariat> findSecretariat(@PathVariable Long id) { return this.secretariatService.findSecretariat(id); }

    @PatchMapping("{id}/investigation")
    @ApiOperation(value = "Change secretariat investigation status",
            notes = "This method finds a secretariat by its id and changes the investigation status.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Secretariat changed"),
            @ApiResponse(code = 500, message = "Internal Error"),
    })
    public Secretariat changeInvestigation(@PathVariable Long id, @Valid @RequestBody ChangeInvestigationRequest changeInvestigationRequest) throws BusinessException {
        return this.secretariatService.changeInvestigation(id, changeInvestigationRequest);
    }
}
