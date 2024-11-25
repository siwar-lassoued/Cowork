package com.cowork.cowork.Repository;

import com.cowork.cowork.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findBydateDebut(LocalDateTime dateDebut);
    List<Reservation> findBydateFin(LocalDateTime dateFin);

}
