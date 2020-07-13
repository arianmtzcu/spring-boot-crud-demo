package com.arian.example.service.impl;

import com.arian.example.commons.GenericServiceImpl;
import com.arian.example.dao.api.CamisetaDaoAPI;
import com.arian.example.model.Camiseta;
import com.arian.example.model.Marca;
import com.arian.example.service.api.CamisetaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CamisetaServiceImpl extends GenericServiceImpl<Camiseta, Long> implements CamisetaServiceAPI {

    @Autowired
    private CamisetaDaoAPI camisetaDaoAPI;

    @Override
    public CrudRepository<Camiseta, Long> getDao() {
        return camisetaDaoAPI;
    }

    public Camiseta findCamisetaByid(Long idcamiseta) {
        System.out.println("CamisetaServiceImpl -> findCamisetaByid");
        Optional<Camiseta> obj = getDao().findById(idcamiseta);
        if (obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

    @Override
    public List<Camiseta> findByCamisetaId(List<Long> ids) {
        System.out.println("CamisetaServiceImpl -> findByCamisetaId");
        return (List<Camiseta>) camisetaDaoAPI.findAll(new Specification<Camiseta>() {
            @Override
            public Predicate toPredicate(Root<Camiseta> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(ids!=null && !ids.isEmpty()) {
                    predicates.add(root.get("id").in(ids));
                    predicates.add(root.get("numero").in(10));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }

    public List<Marca> testListMarcas() {
        EntityManager entityManager = null;

        TypedQuery<Marca> query = entityManager.createQuery(
                "SELECT m FROM camiseta c, marca m", Marca.class);
        List<Marca> resultList = query.getResultList();
        return resultList;
    }

}
