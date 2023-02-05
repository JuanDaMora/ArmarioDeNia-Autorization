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
public class ColorProductDTO implements Serializable {
    private static final long serialVersionUID = 4348049862813838773L;
    private Long id;
    @NotNull
    private Long id_color;
    @NotNull
    private Long id_product;
}
