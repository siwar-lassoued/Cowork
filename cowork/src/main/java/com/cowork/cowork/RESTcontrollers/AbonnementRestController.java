package com.cowork.cowork.RESTcontrollers;

import com.cowork.cowork.Model.Abonnement;
import com.cowork.cowork.Service.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("abonnement")
public class AbonnementRestController {
    @Autowired
    AbonnementService abonnementService;

    //AjouterAbonnement
    @PostMapping("/save")
    public ResponseEntity<Abonnement> createAbonnement(@RequestBody Abonnement abonnement) {
        try {
            abonnementService.createAbonnement(abonnement);
            return new ResponseEntity<Abonnement>(abonnement, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Abonnement>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ListAbonnement
    @GetMapping("/all")
    public ResponseEntity<List<Abonnement>> getAllAbonnement() {
        try {
            List<Abonnement> abonnements = abonnementService.getAllAbonnement();
            if (abonnements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(abonnements, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //GetAbonnementById
    @GetMapping("/abonnements/{id}")
    public ResponseEntity<Abonnement> getAbonnementById(@PathVariable int id) {
        Abonnement abonnement = abonnementService.getAbonnementById(id);

        if (abonnement != null) {
            return new ResponseEntity<Abonnement>(abonnement, HttpStatus.OK);
        } else {
            return new ResponseEntity<Abonnement>(HttpStatus.NOT_FOUND);
        }
    }


    //UpdateAbonnement
    @PutMapping("/update/{id}")
    public Abonnement updateAbonnement(@PathVariable int id, @RequestBody Abonnement abonnement) {
        Abonnement c1 = abonnementService.getAbonnementById(id);
        if (c1 != null) {
            abonnement.setId(id);
            return abonnementService.updateAbonnement(abonnement);
        } else {
            throw new RuntimeException("Failed!");
        }
    }

    //DeleteAbonnement
    @DeleteMapping("/abonnements/{id}")
    public HashMap<String,String> deleteAbonnement(@PathVariable int id) {
        HashMap<String,String> message = new HashMap<>();
        if (abonnementService.getAbonnementById(id) == null) {
            message.put("etat", "Abonnement not found");
            return message;
        }
        try {
            abonnementService.deleteAbonnement(id);
            message.put("etat", "Abonnement deleted");
            return message;
        }catch (Exception e) {
            message.put("etat", "Abonnement not deleted");
            return message;
        }
    }








}
