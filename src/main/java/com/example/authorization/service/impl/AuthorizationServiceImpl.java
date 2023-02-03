package com.example.authorization.service.impl;

import com.example.authorization.dto.JwtDTO;
import com.example.authorization.dto.LoginDTO;
import com.example.authorization.exception.TransactionException;
import com.example.authorization.security.JwtTokenUtil;
import com.example.authorization.service.interfaces.IAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author Daniel Adrian Gonzalez Buendia
 */

@Service
public class AuthorizationServiceImpl  implements IAuthorizationService {

    private JwtTokenUtil jwtTokenUtil;

    private AuthenticationManager authenticationManager;

    private JwtUserDetailsServiceImpl jwtUserDetailsService;

    public JwtDTO login(LoginDTO loginDTO) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        } catch (Exception e) {
            throw new TransactionException("Invalid username or password");
        }
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(loginDTO.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails, jwtUserDetailsService.user.getId());
        return new JwtDTO(token);
    }

    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Autowired
    @Lazy
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtUserDetailsService(JwtUserDetailsServiceImpl jwtUserDetailsService) {
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

}
