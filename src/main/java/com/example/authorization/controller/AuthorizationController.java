package com.example.authorization.controller;

import com.example.authorization.dto.JwtDTO;
import com.example.authorization.dto.LoginDTO;
import com.example.authorization.dto.UserDTO;
import com.example.authorization.service.interfaces.IAuthorizationService;
import com.example.authorization.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Daniel Adrian Gonzalez Buendia
 **/
@CrossOrigin(origins = "http://10.14.8.75")
@RestController
@RequestMapping("/public/api")
public class AuthorizationController {

    private IAuthorizationService authorizationService;
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(this.authorizationService.login(loginDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<Boolean> createUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(this.userService.createUser(userDTO));
    }

    @Autowired
    public void setAuthorizationService( IAuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Autowired
    
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

}
