package com.cowork.cowork.Controller;

import com.cowork.cowork.Model.EspaceDeTravail;
import com.cowork.cowork.Service.EspaceDeTravailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EspaceDeTravailleController {
    @Autowired
    private EspaceDeTravailService espaceDeTravailService;

    @RequestMapping("/addEspace")
    public String addEspace(Model model) {
        EspaceDeTravail espaceDeTravail = new EspaceDeTravail();
        model.addAttribute("EspaceForm", espaceDeTravail);
        return "new_espace"; // Page Thymeleaf
    }

    @RequestMapping(value = "/saveEspace", method = RequestMethod.POST)
    public String saveEspace(@ModelAttribute("EspaceForm") EspaceDeTravail espaceDeTravail) {
        espaceDeTravailService.createEspaceDeTravail(espaceDeTravail);
        return "redirect:/allEspaces";
    }

    @RequestMapping("/allEspaces")
    public String getAllEspaces(Model model) {
        List<EspaceDeTravail> espaces = espaceDeTravailService.getAllEspaceDeTravail();
        model.addAttribute("espaces", espaces);
        return "liste_espaces"; // Page Thymeleaf
    }

    @GetMapping("deleteEspace/{id}")
    public String deleteEspace(@PathVariable("id") int id) {
        espaceDeTravailService.deleteEspaceDeTravail((id));
        return "redirect:/allEspaces";
    }

    @GetMapping("editEspace/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        EspaceDeTravail espaceDeTravail = espaceDeTravailService.getEspaceDeTravailById(id);
        model.addAttribute("espace", espaceDeTravail);
        return "update_espace";
    }

    @PostMapping("updateEspace/{id}")
    public String updateEspace(@PathVariable("id") int id, EspaceDeTravail espaceDeTravail){

        espaceDeTravailService.updateEspaceDeTravail(espaceDeTravail);
        return "redirect:/allEspaces";
    }
}
