package com.example.authorization.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @autor Juan David Morantes Vergara
 */
@Getter
@Setter
public class DiscountDTO implements Serializable {
    private static final long serialVersionUID = -1081015908168368687L;
    private Long id;
    @NotNull
    private Long id_product;
    @NotNull
    private String percentage;
    @NotNull
    private Date finish;
}
