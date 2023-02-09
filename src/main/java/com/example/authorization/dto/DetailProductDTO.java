package com.example.authorization.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
@Getter
@Setter
public class DetailProductDTO implements Serializable {
    private static final long serialVersionUID = 6476863212782722364L;
    @NotNull
    private Long id;
    @NotNull
    private String url_photo;
    @NotNull
    private String type_product;
    @NotNull
    private List<String>  color_product;
    @NotNull
    private List<String>  size_product;
    @NotNull
    private String description;
    @NotNull
    private Boolean is_for_womans;
    @NotNull
    private Long amount;
    @NotNull
    private String price;
}
