package com.allstate.controllers;

import com.allstate.entities.Klasses;
import com.allstate.services.KlassesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/klasses")
public class KlassesController {
    private KlassesServices klassesServices;

    @Autowired
    public void setKlassesServices(KlassesServices klassesServices) {
        this.klassesServices = klassesServices;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public Klasses create(@RequestBody Klasses klasses){
        return this.klassesServices.create(klasses);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public Klasses findById(@PathVariable int id){
        return this.klassesServices.findById(id);
    }
}


