package com.arian.example.service.api;

import com.arian.example.commons.GenericServiceAPI;
import com.arian.example.model.Camiseta;
import com.arian.example.model.Marca;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CamisetaServiceAPI extends GenericServiceAPI<Camiseta, Long> {

    Camiseta findCamisetaByid(Long idcamiseta);

    @Query("SELECT c FROM camiseta c WHERE c.id IN (:ids)")     // 2. Spring JPA In cause using @Query
    List<Camiseta> findByCamisetaId(@Param("ids") List<Long> ids);

    List<Marca> testListMarcas();
}
