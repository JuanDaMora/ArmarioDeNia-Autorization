package com.example.authorization.mappers;

import com.example.authorization.dto.DiscountDTO;
import com.example.authorization.model.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @autor Juan David Morantes Vergara
 */
@Mapper
public interface DiscountMapper {
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    Discount toDiscount(DiscountDTO discountDTO);

    DiscountDTO toDiscountDTO(Discount discount);
}
