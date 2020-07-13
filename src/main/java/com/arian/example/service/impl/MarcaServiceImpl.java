package com.arian.example.service.impl;

import com.arian.example.commons.GenericServiceImpl;
import com.arian.example.dao.api.MarcaDaoAPI;
import com.arian.example.model.Marca;
import com.arian.example.service.api.MarcaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl extends GenericServiceImpl<Marca, Long> implements MarcaServiceAPI {

    @Autowired
    private MarcaDaoAPI marcaDaoAPI;

    @Override
    public CrudRepository<Marca, Long> getDao() {
        return marcaDaoAPI;
    }
}
