package com.cowork.cowork.Controller;

import com.cowork.cowork.Model.Reservation;
import com.cowork.cowork.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @RequestMapping("/addReservation")
    public String addReservation(Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("ReservationForm",reservation);
        return "new_reservation";
    }
    @RequestMapping(value = "/saveReservation", method = RequestMethod.POST)
    public String saveReservation(@ModelAttribute("ReservationForm") Reservation reservation) {
        reservationService.createReservation(reservation);
        return "redirect:/allReservations";
    }

    @RequestMapping("/allReservations")
    public String getAllReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservation();
        model.addAttribute("reservations", reservations);
        return "liste_reservations"; // Page Thymeleaf
    }

    @GetMapping("deleteReservation/{id}")
    public String deleteReservation(@PathVariable("id") int id) {
        reservationService.deleteReservation((id));
        return "redirect:/allReservations";
    }

    @GetMapping("editReservation/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        model.addAttribute("reservation", reservation);
        return "update_reservation";
    }

    @PostMapping("updateReservation/{id}")
    public String updateReservation(@PathVariable("id") int id, Reservation reservation){

        reservationService.updateReservation(reservation);
        return "redirect:/allReservations";
    }

}
