package com.example.authorization.controller;

import com.example.authorization.dto.DetailProductDTO;
import com.example.authorization.dto.DiscountDTO;
import com.example.authorization.dto.ProductDTO;
import com.example.authorization.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
@RestController
@RequestMapping("/public/api/products")
public class ProductController {

    private IProductService productService;
    @Autowired
    @Qualifier("productServiceImpl")
    public void setPublicationService(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id_product}")
    public ResponseEntity<DetailProductDTO> getDetailProducts(@PathVariable Long id_product) {
        DetailProductDTO detailProductDTOS = this.productService.getDetailProduct(id_product);
        return ResponseEntity.ok(detailProductDTOS);
    }

    @PostMapping("/discount")
    public ResponseEntity<Boolean> createDiscount(@Valid @RequestBody DiscountDTO discountDTO){
        return ResponseEntity.ok(productService.createDiscount(discountDTO));
    }



}
