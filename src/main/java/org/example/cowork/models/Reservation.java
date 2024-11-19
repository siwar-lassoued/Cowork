package org.example.cowork.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String typeAbonnement; // mensuel ou annuel
    private double prix;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "espace_de_travail_id")
    private EspaceDeTravail espaceDeTravail;

    // Getters et setters
}

