package com.cowork.cowork.Repository;

import com.cowork.cowork.Model.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    List<Abonnement> findByTypeAbonnement(String typeAbonnement);
    List<Abonnement> findByPrix (double prix);
}

