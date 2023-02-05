package com.example.authorization.mappers;

import com.example.authorization.dto.ColorProductDTO;
import com.example.authorization.model.Color;
import com.example.authorization.model.ColorProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @autor Juan David Morantes Vergara
 */
@Mapper
public interface ColorProductMapper {
    ColorProductMapper INSTANCE = Mappers.getMapper(ColorProductMapper.class);
    ColorProduct toColorProduct(ColorProductDTO colorProductDTO);
    ColorProductDTO toColorProductDTO(ColorProduct colorProduct);
}
