package com.example.authorization.service.impl;

import com.example.authorization.dto.UserDTO;
import com.example.authorization.service.interfaces.IsAdminService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @autor Juan David Morantes Vergara
 */
public class IsAdminServiceImpl implements IsAdminService {
    @Autowired
    private UserServiceImpl userService;
    @Override
    public Boolean is(String token) {
        UserDTO userDTO= userService.getUserDataByToken(token);
        return userDTO.getId_type_user() == 2;
    }
}
