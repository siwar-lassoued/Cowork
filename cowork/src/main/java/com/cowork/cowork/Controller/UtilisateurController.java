package com.cowork.cowork.Controller;

import com.cowork.cowork.Model.Utilisateur;
import com.cowork.cowork.Service.UtilisateurService;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UtilisateurController {
    @Autowired
    UtilisateurService utilisateurService;

    @RequestMapping("/addUser")
    public String addSUser(Model model) {
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute("UserForm", utilisateur);
        return "new_user"; // Page Thymeleaf
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("UserForm") Utilisateur utilisateur) {
        utilisateurService.createUtilisateur(utilisateur);
        return "redirect:/allUsers";
    }

    @RequestMapping("/allUsers")
    public String getAllUsers(Model model) {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateur();
        model.addAttribute("users", utilisateurs);
        return "liste_users"; // Page Thymeleaf
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        utilisateurService.deleteUtilisateur((id));
        return "redirect:/allUsers";
    }

    @GetMapping("editUser/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        model.addAttribute("user", utilisateur);
        return "update_user";
    }

    @PostMapping("updateUser/{id}")
    public String updateUser(@PathVariable("id") int id, Utilisateur utilisateur){

        utilisateurService.updateUtilisateur(utilisateur);
        return "redirect:/allUsers";
    }


}
