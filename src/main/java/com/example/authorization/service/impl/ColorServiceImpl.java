package com.example.authorization.service.impl;

import com.example.authorization.dto.ColorDTO;
import com.example.authorization.dto.UserDTO;
import com.example.authorization.exception.TechnicalException;
import com.example.authorization.mappers.ColorMapper;
import com.example.authorization.model.Color;
import com.example.authorization.repository.IColorRepository;
import com.example.authorization.repository.IUserRepository;
import com.example.authorization.service.interfaces.IColorService;
import com.example.authorization.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @autor Juan David Morantes Vergara
 */
public class ColorServiceImpl implements IColorService {
    @Autowired
    private IColorRepository colorRepository;
    @Autowired
    private IUserService userService;
    @Override
    public List<ColorDTO> getAllColors(String token) {
        UserDTO userDTO= userService.getUserDataByToken(token);
        if(userDTO.getId_type_user()!=2){
            throw new TechnicalException("this user is'not admin");
        }
        List<Color> listColor= colorRepository.findAll();
        List<ColorDTO> colorDTOS=listColor.stream()
                .map(ColorMapper.INSTANCE::toColorDTO).collect(Collectors.toList());
        return colorDTOS;
    }

}
