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
public class ColorDTO implements Serializable {

    private static final long serialVersionUID = -887467537493119764L;
    private Long id;
    @NotNull
    private String description;
}
