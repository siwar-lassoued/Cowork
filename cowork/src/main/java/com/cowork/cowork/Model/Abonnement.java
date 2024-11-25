package com.cowork.cowork.Model;

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

    @Column(name = "TypeAbonnement")
    private String typeAbonnement; // mensuel ou annuel

    @Column(name = "Prix")
    private double prix;

    @OneToOne(mappedBy = "abonnement")
    private Utilisateur utilisateur;
}
