package br.com.mesttra.secretariat.service;

import br.com.mesttra.secretariat.data.SecretariatRepository;
import br.com.mesttra.secretariat.model.Secretariat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecretariatService {

    SecretariatRepository secretariatRepository;

    public SecretariatService(SecretariatRepository secretariatRepository) { this.secretariatRepository = secretariatRepository; }

    public List<Secretariat> listSecretariats() { return secretariatRepository.findAll(); }

    public Secretariat addSecretariat(Secretariat secretariat) { return secretariatRepository.save(secretariat); }

    public Optional<Secretariat> getSecretariat(Long id) { return this.secretariatRepository.findById(id); }
}
