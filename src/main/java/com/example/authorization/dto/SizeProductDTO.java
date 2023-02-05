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
public class SizeProductDTO implements Serializable {

    private static final long serialVersionUID = 7697610000996259283L;
    private Long id;
    @NotNull
    private Long id_size;
    @NotNull
    private Long id_product;
}
