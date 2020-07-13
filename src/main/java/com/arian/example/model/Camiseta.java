package com.arian.example.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Camiseta {

    @Id
    private Long id;
    @Column
    private int numero;
    @Column
    private int idmarca;

}
