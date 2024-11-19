package org.example.cowork.controller;

import org.example.cowork.models.EspaceDeTravail;
import org.example.cowork.service.EspaceDeTravailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espaces")
public class EspaceDeTravailController {
    private final EspaceDeTravailService espaceDeTravailService;

    public EspaceDeTravailController(EspaceDeTravailService espaceDeTravailService) {
        this.espaceDeTravailService = espaceDeTravailService;
    }

    @GetMapping
    public List<EspaceDeTravail> getAllEspaces() {
        return espaceDeTravailService.getAllEspaces();
    }

    @PostMapping
    public EspaceDeTravail createEspace(@RequestBody EspaceDeTravail espace) {
        return espaceDeTravailService.saveEspace(espace);
    }

    @DeleteMapping("/{id}")
    public void deleteEspace(@PathVariable int id) {
        espaceDeTravailService.deleteEspace(id);
    }
}

