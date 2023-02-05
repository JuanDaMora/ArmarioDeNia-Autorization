package com.example.authorization.mappers;

import com.example.authorization.dto.SizeProductDTO;
import com.example.authorization.model.SizeProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @autor Juan David Morantes Vergara
 */
@Mapper
public interface SizeProductMapper {
    SizeProductMapper INSTANCE = Mappers.getMapper(SizeProductMapper.class);

    SizeProduct toSizeProduct(SizeProductDTO sizeProductDTO);
    SizeProductDTO toSizeProductDTO(SizeProduct sizeProduct);
}
