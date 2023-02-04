package com.example.authorization.mappers;

import com.example.authorization.dto.ColorDTO;
import com.example.authorization.model.Color;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @autor Juan David Morantes Vergara
 */
@Mapper
public interface ColorMapper {
    ColorMapper INSTANCE = Mappers.getMapper(ColorMapper.class);

    // Mapping User to UserDTO
    ColorDTO toColorDTO(Color color);

    // Mapping UserDTO to User
    Color toColor(ColorDTO colorDTO);
}
