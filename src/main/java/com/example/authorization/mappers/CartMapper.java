package com.example.authorization.mappers;

import com.example.authorization.dto.CartDTO;
import com.example.authorization.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @autor Juan David Morantes Vergara
 */
@Mapper
public interface CartMapper {
    CartMapper INSTANCE= Mappers.getMapper(CartMapper.class);

    CartDTO toCartDTO(Cart cart);

    Cart toCart(CartDTO cartDTO);
}
