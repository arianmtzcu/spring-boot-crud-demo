package com.arian.example.dao.api;

import com.arian.example.model.Camiseta;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CamisetaDaoAPI extends CrudRepository<Camiseta, Long> {

    List<Camiseta> findAll(Specification<Camiseta> id);
}
