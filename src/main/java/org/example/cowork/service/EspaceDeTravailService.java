package org.example.cowork.service;

import org.example.cowork.models.EspaceDeTravail;
import org.example.cowork.repository.EspaceDeTravailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspaceDeTravailService {
    private final EspaceDeTravailRepository espaceDeTravailRepository;

    public EspaceDeTravailService(EspaceDeTravailRepository espaceDeTravailRepository) {
        this.espaceDeTravailRepository = espaceDeTravailRepository;
    }

    public List<EspaceDeTravail> getAllEspaces() {
        return espaceDeTravailRepository.findAll();
    }

    public List<EspaceDeTravail> getDisponibles() {
        return espaceDeTravailRepository.findByDisponibilite(true);
    }

    public EspaceDeTravail saveEspace(EspaceDeTravail espace) {
        return espaceDeTravailRepository.save(espace);
    }

    public void deleteEspace(int id) {
        espaceDeTravailRepository.deleteById(id);
    }
}
