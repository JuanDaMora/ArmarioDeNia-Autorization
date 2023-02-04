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
@Table(schema = "armariodenia", name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = -3412838704915893943L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "is_for_womans", nullable = false)
    private Boolean is_for_womans;
    @Column(name = "amount", nullable = false)
    private Long  amount;
    @Column(name = "price ", nullable = false)
    private String price ;

    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created = new Date();

    @Column(name = "updated")
    @Temporal(TemporalType.DATE)
    private Date updated = new Date();
}
