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
@Table(schema = "armariodenia", name = "discount")
public class Discount implements Serializable {
    private static final long serialVersionUID = 3748530045060531032L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_product", nullable = false)
    private Long id_product;
    @Column(name = "percentage", nullable = false)
    private String percentage;

    @Column(name = "finish", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date finish;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created = new Date();

    @Column(name = "updated")
    @Temporal(TemporalType.DATE)
    private Date updated = new Date();


}
