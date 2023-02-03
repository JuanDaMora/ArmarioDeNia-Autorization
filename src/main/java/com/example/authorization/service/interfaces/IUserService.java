package com.example.authorization.service.interfaces;

import com.example.authorization.dto.UserDTO;

/**
 * @autor Juan David Morantes Vergara
 */
public interface IUserService {
    UserDTO getUserDataByToken(String token);
    Boolean createUser(UserDTO userDTO);
}
