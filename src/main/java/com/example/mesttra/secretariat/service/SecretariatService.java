package com.example.mesttra.secretariat.service;

import com.example.mesttra.secretariat.data.SecretariatRepository;
import com.example.mesttra.secretariat.model.Secretariat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretariatService {

    SecretariatRepository secretariatRepository;

    public SecretariatService(SecretariatRepository secretariatRepository) { this.secretariatRepository = secretariatRepository; }

    public List<Secretariat> listSecretariats() { return secretariatRepository.findAll(); }
}
