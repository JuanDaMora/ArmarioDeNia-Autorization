package com.example.authorization.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @autor Juan David Morantes Vergara
 */
@Entity
@Data
@NoArgsConstructor
@Table(schema = "armariodenia", name = "size_product")
public class SizeProduct implements Serializable {
    private static final long serialVersionUID = 6359664223949405347L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "id_size", nullable = false)
    private Long id_size;
    @Column(name = "id_product", nullable = false)
    private Long id_product;
}
