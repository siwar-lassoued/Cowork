package com.cowork.cowork.Model;

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

    @Column(name = "DateDebut")
    private LocalDateTime dateDebut;

    @Column(name = "DateFin")
    private LocalDateTime dateFin;

    @Column(name = "TypeAbonnement")
    private String typeAbonnement; // mensuel ou annuel

    @Column(name = "Prix")
    private double prix;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "espace_de_travail_id")
    private EspaceDeTravail espaceDeTravail;
}
