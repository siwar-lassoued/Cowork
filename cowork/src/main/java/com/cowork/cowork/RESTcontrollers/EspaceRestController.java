package com.cowork.cowork.RESTcontrollers;

import com.cowork.cowork.Model.EspaceDeTravail;
import com.cowork.cowork.Service.EspaceDeTravailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("espace")
public class EspaceRestController {
    @Autowired
    EspaceDeTravailService espaceDeTravailService;

    //AjouterEspace
    @PostMapping("/save")
    public ResponseEntity<EspaceDeTravail> createEspace(@RequestBody EspaceDeTravail espaceDeTravail) {
        try {
            espaceDeTravailService.createEspaceDeTravail(espaceDeTravail);
            return new ResponseEntity<EspaceDeTravail>(espaceDeTravail, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<EspaceDeTravail>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //ListEspace
    @GetMapping("/all")
    public ResponseEntity<List<EspaceDeTravail>> getAllEspaceDeTravail() {
        try {
            List<EspaceDeTravail> espaceDeTravails = espaceDeTravailService.getAllEspaceDeTravail();

            if (espaceDeTravails.isEmpty()) {
                return new ResponseEntity<List<EspaceDeTravail>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<EspaceDeTravail>>(espaceDeTravails, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<List<EspaceDeTravail>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //GetEspaceById
    @GetMapping("/espaces/{id}")
    public ResponseEntity<EspaceDeTravail> getEspaceDeTravail(@PathVariable int id) {
        EspaceDeTravail espaceDeTravail = espaceDeTravailService.getEspaceDeTravailById(id);

        if (espaceDeTravail != null) {
            return new ResponseEntity<EspaceDeTravail>(espaceDeTravail, HttpStatus.OK);
        } else {
            return new ResponseEntity<EspaceDeTravail>(HttpStatus.NOT_FOUND);
        }
    }


    //updateEspace
    @PutMapping("/update/{id}")
    public EspaceDeTravail updateEspace(@PathVariable int id, @RequestBody EspaceDeTravail espaceDeTravail) {
        EspaceDeTravail c1 = espaceDeTravailService.getEspaceDeTravailById(id);
        if (c1 != null) {
            espaceDeTravail.setId(id);
            return espaceDeTravailService.updateEspaceDeTravail(espaceDeTravail);
        } else {
            throw new RuntimeException("Failed!!");
        }
    }

    //DeleteEspace
    @DeleteMapping("/espaces/{id}")
    public HashMap<String,String> deleteEspace(@PathVariable int id) {
        HashMap<String,String> message = new HashMap<>();
        if (espaceDeTravailService.getEspaceDeTravailById(id) == null) {
            message.put("etat", "espace not found");
            return message;
        }
        try {
            espaceDeTravailService.deleteEspaceDeTravail(id);
            message.put("etat", "espace deleted");
            return message;
        } catch (Exception e) {
            message.put("etat", "espace not deleted");
            return message;
        }
    }

}
