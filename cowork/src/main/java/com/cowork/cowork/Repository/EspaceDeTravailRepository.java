package com.cowork.cowork.Repository;

import com.cowork.cowork.Model.EspaceDeTravail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EspaceDeTravailRepository extends JpaRepository<EspaceDeTravail, Integer> {
    List<EspaceDeTravailRepository> findByNom(String nom);
    List<EspaceDeTravailRepository> findByTypeEspace(String TypeEspace);

}
