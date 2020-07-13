package com.arian.example.controller;

import com.arian.example.model.Camiseta;
import com.arian.example.service.api.CamisetaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/api/v1/camiseta/")
public class CamisetaRestController {

    @Autowired
    private CamisetaServiceAPI camisetaServiceAPI;

    @GetMapping(value = "/all")
    public List<Camiseta> getAll() {
        return camisetaServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Camiseta find(@PathVariable Long id) {
        return camisetaServiceAPI.get(id);
    }

    @GetMapping(value = "/findCamiseta/{id}")
    public List<Camiseta> find1(@PathVariable Long id){
        List<Long> miLista = new ArrayList<Long>();
        miLista.add(Long.valueOf(1));
        miLista.add(Long.valueOf(2));

        List<Camiseta> ids = camisetaServiceAPI.findByCamisetaId(miLista);
        //List<Marca> marcas = camisetaServiceAPI.testListMarcas();
        return ids;
    }


}
