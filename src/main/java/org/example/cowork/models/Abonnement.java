package org.example.cowork.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeAbonnement; // mensuel ou annuel
    private double prix;

    @OneToOne(mappedBy = "abonnement")
    private Utilisateur utilisateur;

    // Getters et setters
}

