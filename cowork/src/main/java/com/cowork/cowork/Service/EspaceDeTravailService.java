package com.cowork.cowork.Service;

import com.cowork.cowork.Model.EspaceDeTravail;
import com.cowork.cowork.Repository.EspaceDeTravailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspaceDeTravailService {
    @Autowired
    EspaceDeTravailRepository espaceDeTravailRepository;

    public EspaceDeTravail createEspaceDeTravail(EspaceDeTravail espaceDeTravail) {
        return espaceDeTravailRepository.save(espaceDeTravail);
    }

    public List<EspaceDeTravail> getAllEspaceDeTravail() {
        return espaceDeTravailRepository.findAll();
    }

    public EspaceDeTravail getEspaceDeTravailById(int id) {
        return espaceDeTravailRepository.findById(id).get();
    }

    public EspaceDeTravail updateEspaceDeTravail(EspaceDeTravail espaceDeTravail) {
        return espaceDeTravailRepository.saveAndFlush(espaceDeTravail);
    }

    public void deleteEspaceDeTravail(int id) {
        espaceDeTravailRepository.deleteById(id);
    }

}
