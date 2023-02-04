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
@Table(schema = "armariodenia", name = "user")
public class User implements Serializable{
    private static final long serialVersionUID = 7707531835397997927L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "id_type_user", nullable = false)
    private Long id_type_user;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "names", nullable = false)
    private String names;
    @Column(name = "lastnames", nullable = false)
    private String lastNames;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "postal_code")
    private String postal_code;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created = new Date();

    @Column(name = "updated")
    @Temporal(TemporalType.DATE)
    private Date updated = new Date();
}
