package com.example.authorization.service.interfaces;

import com.example.authorization.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */

public interface IProductService {
     List<ProductDTO> getProducts();

     DetailProductDTO getDetailProduct(Long id_product);

     Boolean createDiscount(DiscountDTO discountDTO);

     Boolean deleteProduct(Long id_product);

     Boolean addCart(Long id_user, Long id_product);
}
