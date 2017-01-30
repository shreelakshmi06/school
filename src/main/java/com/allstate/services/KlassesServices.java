package com.allstate.services;

import com.allstate.entities.Klasses;
import com.allstate.repositories.IKlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlassesServices {
    private IKlassRepository klassRepository;

    @Autowired
    public void setKlassRepository(IKlassRepository klassRepository) {
        this.klassRepository = klassRepository;
    }

    public Klasses create (Klasses klass1){
        return this.klassRepository.save(klass1);
    }

    public Klasses findById(int id){
        return this.klassRepository.findOne(id);
    }
}
