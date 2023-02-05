package com.example.authorization.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @autor Juan David Morantes Vergara
 */
@Entity
@Data
@NoArgsConstructor
@Table(schema = "armariodenia", name = "type_product")
public class TypeProduct implements Serializable {
    private static final long serialVersionUID = 767984601229049269L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "id_types", nullable = false)
    private Long id_types;
    @Column(name = "id_product", nullable = false)
    private Long id_product;

    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created = new Date();

    @Column(name = "updated")
    @Temporal(TemporalType.DATE)
    private Date updated = new Date();
}
