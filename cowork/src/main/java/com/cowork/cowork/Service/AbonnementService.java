package com.cowork.cowork.Service;

import com.cowork.cowork.Model.Abonnement;
import com.cowork.cowork.Repository.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonnementService {

    @Autowired
    AbonnementRepository abonnementRepository;

    public Abonnement createAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    public List<Abonnement> getAllAbonnement() {
        return abonnementRepository.findAll();
    }

    public Abonnement getAbonnementById(long id) {
        return abonnementRepository.findById(id).get();

    }

    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementRepository.saveAndFlush(abonnement);
    }

    public void deleteAbonnement(long id) {
        abonnementRepository.deleteById(id);
    }


}
