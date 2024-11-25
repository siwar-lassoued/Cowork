package com.cowork.cowork.Controller;

import org.springframework.ui.Model;
import com.cowork.cowork.Model.Abonnement;
import com.cowork.cowork.Service.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class AbonnementController {
    @Autowired
    private AbonnementService abonnementService;

    @RequestMapping("/addAbonnement")
    public String addAbonnement(Model model) {
        Abonnement abonnement = new Abonnement();
        model.addAttribute("AbonnementForm",abonnement);
        return "new_reservation";

    }

    @RequestMapping(value = "/saveAbonnement",method = RequestMethod.POST)
    public String saveAbonnement(@ModelAttribute("AbonnementForm") Abonnement abonnement) {
        abonnementService.createAbonnement(abonnement);
        return "redirect:/allAbonnements";
    }

    @RequestMapping("/allAbonnements")
    public String getAllAbonnements(Model model) {
        List<Abonnement> abonnements=abonnementService.getAllAbonnement();
        model.addAttribute("Abonnements",abonnements);
        return "liste_abonnements";
    }

    @GetMapping("deleteAbonnement/{id}")
    public String deleteAbonnement(@PathVariable("id") int id) {
        abonnementService.deleteAbonnement((id));
        return "redirect:/allAbonnements";
    }

    @GetMapping("editAbonnement/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Abonnement abonnement=abonnementService.getAbonnementById(id);
        model.addAttribute("Abonnement",abonnement);
        return "update_abonnement";
    }

    @PostMapping("updateAbonnement/{id}")
    public String updateAbonnement(@PathVariable("id") int id, Abonnement abonnement) {
        abonnementService.updateAbonnement(abonnement);
        return "redirect:/allAbonnements";
    }



}
