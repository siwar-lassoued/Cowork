package com.cowork.cowork.RESTcontrollers;

import com.cowork.cowork.Model.Utilisateur;
import com.cowork.cowork.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("utilisateur")
public class UtilisateurRestController {
    @Autowired
    UtilisateurService utilisateurService;

    //AjouterUtilisateur
    @PostMapping("/save")
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        try {
            utilisateurService.createUtilisateur(utilisateur);
            return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Utilisateur>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ListUtilisateur
    @GetMapping("/all")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        try {
            List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateur();

            if(utilisateurs.isEmpty()) {
                return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<List<Utilisateur>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    //GetUtilisateurById
    @GetMapping("/utilisateurs/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurByID(@PathVariable("id") int id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);

        if(utilisateur != null) {
            return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
        }else {
            return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
        }
    }


    //UpdateUtilisateur
    @PutMapping("/update/{id}")
    public Utilisateur updateUtilisateur(@PathVariable int id, @RequestBody Utilisateur utilisateur) {
        Utilisateur c1 = utilisateurService.getUtilisateurById(id);
        if (c1 != null) {
            utilisateur.setId(id);
            return utilisateurService.updateUtilisateur(utilisateur);
        } else {
            throw new RuntimeException("Failed!!");
        }
    }


    //DeleteUser
    @DeleteMapping("/utilisateur/{id}")
    public HashMap<String,String> deleteUtilisateur(@PathVariable int id) {
        HashMap<String, String> message = new HashMap<>();
        if (utilisateurService.getUtilisateurById(id) == null) {
            message.put("etat", "user not found");
            return message;
        }
        try {
            utilisateurService.deleteUtilisateur(id);
            message.put("etat", "user deleted ");
            return message;
        } catch (Exception e) {
            message.put("etat", "user not deleted");
            return message;
        }
    }
}
