package com.example.authorization.service.impl;

import com.example.authorization.dto.ProductDTO;
import com.example.authorization.dto.UserDTO;
import com.example.authorization.mappers.ColorMapper;
import com.example.authorization.mappers.ProductMapper;
import com.example.authorization.model.Product;
import com.example.authorization.repository.IColorRepository;
import com.example.authorization.repository.IProductRepository;
import com.example.authorization.service.interfaces.IProductService;
import com.example.authorization.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @autor Juan David Morantes Vergara
 */
public class ProductServiceImpl implements IProductService {

    private IProductRepository productRepository;
    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> listProduct= productRepository.findAll();
        return listProduct.stream()
                .map(ProductMapper.INSTANCE::toProductDTO).collect(Collectors.toList());
    }

    @Autowired
    public void SetProductRepository(IProductRepository productRepository) {
        this.productRepository =productRepository;
    }

}
