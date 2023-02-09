package com.example.authorization.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @autor Juan David Morantes Vergara
 */
@Entity
@Data
@NoArgsConstructor
@Table(schema = "armariodenia", name = "cart")
public class Cart implements Serializable {
    private static final long serialVersionUID = -7373570986733144114L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "id_user", nullable = false)
    private Long id_user;
    @Column(name = "id_product", nullable = false)
    private Long id_product;

    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created = new Date();

    @Column(name = "updated")
    @Temporal(TemporalType.DATE)
    private Date updated = new Date();

}
