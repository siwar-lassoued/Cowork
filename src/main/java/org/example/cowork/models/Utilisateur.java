package org.example.cowork.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String email;
    private String motDePasse;
    private String role; // admin ou membre

    @OneToOne(cascade = CascadeType.ALL)
    private Abonnement abonnement;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

   // @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    //private List<Paiement> paiements;

    // Getters et setters
}
