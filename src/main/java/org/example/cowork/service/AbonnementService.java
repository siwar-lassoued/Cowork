package org.example.cowork.service;

import org.example.cowork.models.Abonnement;
import org.example.cowork.repository.AbonnementRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AbonnementService {

    private final AbonnementRepository abonnementRepository;

    public AbonnementService(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    // Récupérer tous les abonnements
    public List<Abonnement> getAllAbonnements() {
        return abonnementRepository.findAll();
    }

    // Récupérer un abonnement par son ID
    public Optional<Abonnement> getAbonnementById(int id) {
        return abonnementRepository.findById(id);
    }

    // Créer un nouvel abonnement
    public Abonnement saveAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    // Mettre à jour un abonnement
    public Abonnement updateAbonnement(int id, Abonnement updatedAbonnement) {
        return abonnementRepository.findById(id).map(abonnement -> {
            abonnement.setTypeAbonnement(updatedAbonnement.getTypeAbonnement());
            abonnement.setPrix(updatedAbonnement.getPrix());
            return abonnementRepository.save(abonnement);
        }).orElseThrow(() -> new RuntimeException("Abonnement avec ID " + id + " introuvable"));
    }

    // Supprimer un abonnement par son ID
    public void deleteAbonnement(int id) {
        if (abonnementRepository.existsById(id)) {
            abonnementRepository.deleteById(id);
        } else {
            throw new RuntimeException("Abonnement avec ID " + id + " introuvable");
        }
    }
}
