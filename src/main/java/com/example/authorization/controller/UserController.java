package com.example.authorization.controller;

import com.example.authorization.dto.UserDTO;
import com.example.authorization.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Daniel Adrian Gonzalez Buendia
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private IUserService userService;


    @GetMapping
    public ResponseEntity<UserDTO> getUser(@RequestHeader("Authorization") String token) {
        UserDTO userDTO = this.userService.getUserDataByToken(token);
        return ResponseEntity.ok(userDTO);
    }

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
