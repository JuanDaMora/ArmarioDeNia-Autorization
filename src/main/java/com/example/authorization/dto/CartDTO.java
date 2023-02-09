package com.example.authorization.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @autor Juan David Morantes Vergara
 */
@Getter
@Setter
public class CartDTO implements Serializable {

    private static final long serialVersionUID = -76121696217978729L;
    private Long id_user;
    private Long id_product;
}
