package com.example.authorization.service.interfaces;

import com.example.authorization.dto.UserDTO;
import org.springframework.stereotype.Service;

/**
 * @autor Juan David Morantes Vergara
 */
@Service
public interface IUserService {
    UserDTO getUserDataByToken(String token);
    Boolean createUser(UserDTO userDTO);
}
