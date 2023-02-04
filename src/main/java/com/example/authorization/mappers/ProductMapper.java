package com.example.authorization.mappers;

import com.example.authorization.dto.ProductDTO;
import com.example.authorization.dto.UserDTO;
import com.example.authorization.model.Product;
import com.example.authorization.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @autor Juan David Morantes Vergara
 */
@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE= Mappers.getMapper(ProductMapper.class);

    ProductDTO toProductDTO(Product product);

    Product toProduct(ProductDTO productDTO);
}
