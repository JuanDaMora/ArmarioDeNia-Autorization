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
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 2574454800094691855L;
    private Long id;
    @NotNull
    private String description;
    @NotNull
    private Boolean is_for_womans;
    @NotNull
    private String type_product;
    @NotNull
    private Long amount;
    @NotNull
    private String price;
    @NotNull
    private String url_photo;
}
