package com.example.authorization.service.interfaces;

import com.example.authorization.dto.*;
import com.example.authorization.model.*;

import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
public interface IProductService {
     List<DetailProductDTO> getDetailProducts();


    List<SizeProduct> getAllSizeProducts();

    List<ColorProduct> getAllColorProducts();

    List<TypeProduct> getAllTypeProducts();

    List<Product> getAllProducts();
}
