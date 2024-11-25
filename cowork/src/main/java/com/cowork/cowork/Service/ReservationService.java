package com.cowork.cowork.Service;

import com.cowork.cowork.Model.EspaceDeTravail;
import com.cowork.cowork.Model.Reservation;
import com.cowork.cowork.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(int id) {
        return reservationRepository.findById(id).get();
    }

    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.saveAndFlush(reservation);
    }

    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }
}
