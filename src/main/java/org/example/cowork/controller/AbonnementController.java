package org.example.cowork.controller;

import org.example.cowork.models.Abonnement;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/abonnements")
public class AbonnementController {

    private final AbonnementService abonnementService;

    public AbonnementController(AbonnementService abonnementService) {
        this.abonnementService = abonnementService;
    }

    // Récupérer tous les abonnements
    @GetMapping
    public List<Abonnement> getAllAbonnements() {
        return abonnementService.getAllAbonnements();
    }

    // Récupérer un abonnement par son ID
    @GetMapping("/{id}")
    public Abonnement getAbonnementById(@PathVariable int id) {
        return abonnementService.getAbonnementById(id)
                .orElseThrow(() -> new RuntimeException("Abonnement avec ID " + id + " introuvable"));
    }

    // Créer un nouvel abonnement
    @PostMapping
    public Abonnement createAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementService.saveAbonnement(abonnement);
    }

    // Mettre à jour un abonnement
    @PutMapping("/{id}")
    public Abonnement updateAbonnement(@PathVariable int id, @RequestBody Abonnement abonnement) {
        return abonnementService.updateAbonnement(id, abonnement);
    }

    // Supprimer un abonnement par son ID
    @DeleteMapping("/{id}")
    public void deleteAbonnement(@PathVariable int id) {
        abonnementService.deleteAbonnement(id);
    }
}

