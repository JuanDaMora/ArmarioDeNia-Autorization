package com.example.authorization.controller;

import com.example.authorization.dto.ColorDTO;
import com.example.authorization.dto.UserDTO;
import com.example.authorization.service.interfaces.IColorService;
import com.example.authorization.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
@RestController
@RequestMapping("/api/admin")
public class ColorController {
    private IColorService colorService;


    @GetMapping("/colors")
    public ResponseEntity<List<ColorDTO>> getAllColors(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(colorService.getAllColors(token));
    }
    @Autowired
    public void setColorService(IColorService colorService) {
        this.colorService = colorService;
    }
}
