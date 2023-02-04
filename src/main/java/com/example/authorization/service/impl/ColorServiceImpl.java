package com.example.authorization.service.impl;

import com.example.authorization.dto.ColorDTO;
import com.example.authorization.exception.TechnicalException;
import com.example.authorization.mappers.ColorMapper;
import com.example.authorization.model.Color;
import com.example.authorization.repository.IColorRepository;
import com.example.authorization.repository.IUserRepository;
import com.example.authorization.service.interfaces.IColorService;
import com.example.authorization.service.interfaces.IsAdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @autor Juan David Morantes Vergara
 */
public class ColorServiceImpl implements IColorService {
    @Autowired
    private IsAdminService isAdmin;

    private IColorRepository colorRepository;
    @Override
    public List<ColorDTO> getAllColors(String token) {
        if(!isAdmin.is(token)){
            throw new TechnicalException("this user is'not admin");
        }else {
            List<Color> listColor = colorRepository.findAll();
            List<ColorDTO> colorDTOS = listColor.stream()
                    .map(ColorMapper.INSTANCE::toColorDTO).collect(Collectors.toList());
            return colorDTOS;
        }
    }
    @Autowired
    public void setColorRepository(IColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }


}
