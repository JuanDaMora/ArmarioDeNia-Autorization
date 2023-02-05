package com.example.authorization.mappers;

import com.example.authorization.dto.TypeProductDTO;
import com.example.authorization.model.TypeProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @autor Juan David Morantes Vergara
 */
@Mapper
public interface TypeProductMapper {
    TypeProductMapper INSTANCE = Mappers.getMapper(TypeProductMapper.class);
    TypeProduct toTypeProduct(TypeProductDTO typeProduct);
    TypeProductDTO toTypeProductDTO(TypeProduct typeProductDTO);
}
