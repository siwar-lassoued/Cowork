package org.example.cowork.repository;

import org.example.cowork.models.EspaceDeTravail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EspaceDeTravailRepository extends JpaRepository<EspaceDeTravail, Integer> {
    List<EspaceDeTravail> findByDisponibilite(boolean disponibilite);
}

