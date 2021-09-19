package br.com.mesttra.secretariat.service;

import br.com.mesttra.secretariat.data.SecretariatRepository;
import br.com.mesttra.secretariat.exception.BusinessException;
import br.com.mesttra.secretariat.model.Secretariat;
import br.com.mesttra.secretariat.request.ChangeInvestigationRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SecretariatService {

    SecretariatRepository secretariatRepository;

    public SecretariatService(SecretariatRepository secretariatRepository) { this.secretariatRepository = secretariatRepository; }

    public List<Secretariat> listSecretariats() { return secretariatRepository.findAll(); }

    public Secretariat addSecretariat(Secretariat secretariat) { return secretariatRepository.save(secretariat); }

    public Optional<Secretariat> findSecretariat(Long id) { return this.secretariatRepository.findById(id); }

    @Transactional
    public Secretariat changeInvestigation(Long id, ChangeInvestigationRequest changeInvestigationRequest) throws BusinessException {

        Optional<Secretariat> secretariatOptional = this.secretariatRepository.findById(id);

        if (secretariatOptional.isEmpty())
        {
            throw new BusinessException("Secretariat not found.");
        }

        Secretariat secretariat = secretariatOptional.get();
        secretariat.setUnderInvestigation(changeInvestigationRequest.getUnderInvestigation());

        return  this.secretariatRepository.save(secretariat);
    }
}
