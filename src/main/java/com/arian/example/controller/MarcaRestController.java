package com.arian.example.controller;

import com.arian.example.model.Marca;
import com.arian.example.service.api.MarcaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/marca/")
public class MarcaRestController {

    @Autowired
    private MarcaServiceAPI marcaServiceAPI;

    @GetMapping(value = "/all")
    public List<Marca> getAll() {
        return marcaServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Marca find(@PathVariable Long id) {
        return marcaServiceAPI.get(id);
    }


   @PostMapping(value = "/save")
    public ResponseEntity<Marca> save(@RequestBody Marca marca) {
        Marca obj = marcaServiceAPI.save(marca);
        return new ResponseEntity<Marca>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Marca> delete(@PathVariable Long id) {
        Marca marca = marcaServiceAPI.get(id);
        if (marca != null) {
            marcaServiceAPI.delete(id);
        }else {
            return new ResponseEntity<Marca>(marca, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Marca>(marca, HttpStatus.OK);
    }


}
