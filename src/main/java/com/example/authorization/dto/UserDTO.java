package com.example.authorization.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * @autor Juan David Morantes Vergara
 */

@Getter
@Setter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -782222145525600933L;
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String names;
    @NotNull
    private String lastNames;
    @NotNull
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String password;
    private String phone;
    private String address;
    private String postal_code;

}
