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
@CrossOrigin(origins = "http://10.14.8.75")
@RestController
@RequestMapping("/public/api/products")
public class ProductController {

    private IProductService productService;
    @Autowired
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

    @DeleteMapping("/id_product")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id_product){
        return ResponseEntity.ok(productService.deleteProduct(id_product));
    }

    @PostMapping("/discount")
    public ResponseEntity<Boolean> createDiscount(@Valid @RequestBody DiscountDTO discountDTO){
        return ResponseEntity.ok(productService.createDiscount(discountDTO));
    }

    @PostMapping("/cart/{id_user}/{id_pdrodut}")
    public ResponseEntity<Boolean> addCart(@PathVariable Long id_pdrodut,
                                           @PathVariable Long id_user){
        return ResponseEntity.ok(productService.addCart( id_user,id_pdrodut ));
    }


}
