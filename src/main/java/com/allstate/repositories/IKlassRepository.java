package com.allstate.repositories;

import com.allstate.entities.Klasses;
import org.springframework.data.repository.CrudRepository;

public interface IKlassRepository extends CrudRepository<Klasses, Integer>{
    public Klasses findByName(String name);
}
