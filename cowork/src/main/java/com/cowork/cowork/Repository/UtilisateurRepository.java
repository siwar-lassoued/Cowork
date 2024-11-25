package com.cowork.cowork.Repository;

import com.cowork.cowork.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    List<Utilisateur> findByNom(String nom);
    List<Utilisateur> findByEmail(String email);
}
