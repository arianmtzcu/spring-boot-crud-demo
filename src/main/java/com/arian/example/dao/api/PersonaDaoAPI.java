package com.arian.example.dao.api;

import com.arian.example.model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDaoAPI extends CrudRepository<Persona, Long> {

}
