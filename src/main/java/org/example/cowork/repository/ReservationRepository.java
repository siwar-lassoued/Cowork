package org.example.cowork.repository;

import org.example.cowork.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUtilisateurId(int utilisateurId);
}

