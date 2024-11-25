package com.cowork.cowork.Model;

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

    @Column(name = "nom")
    private String nom;

    @Column(name = "TypeEspace")
    private String typeEspace; // bureau, salle de réunion, etc.

    @Column(name = "Capacite")
    private int capacite;

    @Column(name = "Disponibilite")
    private boolean disponibilite;

    @OneToMany(mappedBy = "espaceDeTravail", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
