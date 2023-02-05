package com.example.authorization.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @autor Juan David Morantes Vergara
 */
@Getter
@Setter
public class TypeProductDTO implements Serializable {
    private static final long serialVersionUID = 7209102759614938203L;
    private Long id;
    @NotNull
    private Long id_types;
    @NotNull
    private Long id_product;
}
