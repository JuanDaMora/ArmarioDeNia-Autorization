package com.example.authorization.controller;

import com.example.authorization.dto.ProductDTO;
import com.example.authorization.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
@RestController
@RequestMapping("/api/user/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> productDTO = this.productService.getAllProducts();
        return ResponseEntity.ok(productDTO);
    }

}