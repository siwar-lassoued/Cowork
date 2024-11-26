package com.cowork.cowork.RESTcontrollers;

import com.cowork.cowork.Model.Reservation;
import com.cowork.cowork.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("reservation")
public class ReservationRestController {
    @Autowired
    ReservationService reservationService;

    //AjouterReservation
    @PostMapping("/save")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        try {
            reservationService.createReservation(reservation);
            return new ResponseEntity<Reservation>(reservation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Reservation>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ListReservation
    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        try {
            List<Reservation> reservations = reservationService.getAllReservation();

            if(reservations.isEmpty()) {
                return new ResponseEntity<List<Reservation>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<List<Reservation>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    //GetReservationById
    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") int id) {
        Reservation reservation = reservationService.getReservationById(id);

        if(reservation != null) {
            return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
        }else {
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
    }


    //UpdateReservation
    @PutMapping("/update/{id}")
    public Reservation updateReservation(@PathVariable int id, @RequestBody Reservation reservation) {
        Reservation c1 = reservationService.getReservationById(id);
        if (c1 != null) {
            reservation.setId(id);
            return reservationService.updateReservation(reservation);
        } else {
            throw new RuntimeException("Failed!!");
        }
    }

    //DeleteCategory
    @DeleteMapping("/reservations/{id}")
    public HashMap<String,String> deleteReservation(@PathVariable int id) {
        HashMap<String, String> message = new HashMap<>();
        if (reservationService.getReservationById(id) == null) {
            message.put("etat", "category not found");
            return message;
        }
        try {
            reservationService.deleteReservation(id);
            message.put("etat", "reservation deleted ");
            return message;
        } catch (Exception e) {
            message.put("etat", "reservation not deleted");
            return message;
        }
    }

}
