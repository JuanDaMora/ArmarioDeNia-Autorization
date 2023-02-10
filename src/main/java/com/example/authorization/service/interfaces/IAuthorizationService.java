package com.example.authorization.service.interfaces;

import com.example.authorization.dto.JwtDTO;
import com.example.authorization.dto.LoginDTO;
import org.springframework.stereotype.Service;


public interface IAuthorizationService {
    JwtDTO login(LoginDTO loginDTO);
}
