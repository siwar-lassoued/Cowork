package org.example.cowork.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class EspaceDeTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String typeEspace; // bureau, salle de réunion, etc.
    private int capacite;
    private boolean disponibilite;

    @OneToMany(mappedBy = "espaceDeTravail", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    // Getters et setters
}

