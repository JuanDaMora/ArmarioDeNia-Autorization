package com.example.authorization.service.impl;

import com.example.authorization.dto.*;
import com.example.authorization.exception.DataNotFoundException;
import com.example.authorization.exception.TransactionException;
import com.example.authorization.mappers.CartMapper;
import com.example.authorization.mappers.DiscountMapper;
import com.example.authorization.mappers.ProductMapper;
import com.example.authorization.model.*;
import com.example.authorization.repository.*;
import com.example.authorization.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @autor Juan David Morantes Vergara
 */
@Service
public class ProductServiceImpl implements IProductService {
    private IProductRepository productRepository;
    private IDiscountRepository discountRepository;
    private IColorRepository colorRepository;
    private IColorProductRespository colorProductRespository;
    private ITypeRepository typeRepository;
    private ITypeProductRepository typeProductRepository;
    private ISizeRepository sizeRepository;
    private ISizeProductRepository sizeProductRepository;
    private ICartRepository cartRepository;

    @Override
    public List<ProductDTO> getProducts(){
        List<Product>productList=productRepository.findAll();
        List<ProductDTO> productDTOS=productList.stream()
                .map(ProductMapper.INSTANCE::toProductDTO).collect(Collectors.toList());
        for(ProductDTO productDTO:productDTOS){
            TypeProduct typeProduct=typeProductRepository.getTypeProductById_product(productDTO.getId());
            Type type=typeRepository.getByIdProduct(typeProduct.getId_types());
            productDTO.setType_product(type.getDescription());
        }
        return productDTOS;
    }
    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }
    @Override
    public DetailProductDTO getDetailProduct(Long id_product) {

        Product product=productRepository.findById(id_product)
                .orElseThrow((() -> new DataNotFoundException("Product  not found")));
        DetailProductDTO detailProductDTO=ProductMapper.INSTANCE.toDetailProductDTO(product);
        detailProductDTO.setDescription(capitalizeFirstLetter(detailProductDTO.getDescription()));
        List<ColorProduct> colorList=colorProductRespository.getAllByIdProduct(product.getId());
        List<String> list=new ArrayList<>();
        for(ColorProduct colorProduct:colorList){

            Color color1=colorRepository.findById(colorProduct.getId_color())
                    .orElseThrow((() -> new DataNotFoundException("Color not found")));
            list.add(color1.getDescription());
            detailProductDTO.setColor_product(list);
        }
        list=new ArrayList<>();
        Type type=typeRepository.getByIdProduct(product.getId());
        detailProductDTO.setType_product(type.getDescription());
        list=new ArrayList<>();
        List<SizeProduct> sizeProducts=sizeProductRepository.getAllByIdProduct(product.getId());
        for(SizeProduct sizeProduct:sizeProducts){

            Size size=sizeRepository.findById(sizeProduct.getId_size())
                    .orElseThrow((() -> new DataNotFoundException("Size not found")));
            list.add(size.getDescription());
            detailProductDTO.setSize_product(list);
        }
        detailProductDTO.setDescription(capitalizeFirstLetter(detailProductDTO.getDescription()));
        return detailProductDTO;

    }

    @Override
    public Boolean createDiscount(DiscountDTO discountDTO) {
        if (this.discountRepository.findTopByIdProduct(discountDTO.getId_product()).isPresent()) {
                throw new TransactionException("Discount fot this product already exists");
        }
        Date created = new Date();
        Date finish= discountDTO.getFinish();
        if(finish.before(created)){
            throw new TransactionException("Date finish is before today");
        }
        Discount discount= DiscountMapper.INSTANCE.toDiscount(discountDTO);
        discountRepository.save(discount);

        return true;
    }

    @Override
    public Boolean deleteProduct(Long id_product) {
        try{
            productRepository.deleteById(id_product);
        }catch (Exception e){
            throw new TransactionException("Can't delete product");
        }
        return true;
    }

    @Override
    public Boolean addCart(Long id_user, Long id_product){
        if(cartRepository.verifiCartUser(id_product, id_user) == null){
            CartDTO cartDTO=new CartDTO();
            cartDTO.setId_product(id_product);
            cartDTO.setId_user(id_user);

            Cart cart= CartMapper.INSTANCE.toCart(cartDTO);
            cartRepository.save(cart);
            return true;
        }else{
            return false;
        }

    }


    @Autowired
    public void SetDiscountRepository(IDiscountRepository discountRepository) {
        this.discountRepository=discountRepository;
    }
    @Autowired
    public void SetProductRepository(IProductRepository ProductRespository) {
        this.productRepository=ProductRespository;
    }
    @Autowired
    public void SetIColorProductRespository(IColorProductRespository colorProductRespository) {
        this.colorProductRespository=colorProductRespository;
    }
    @Autowired
    public void SetColorRepository(IColorRepository colorRepository) {
        this.colorRepository=colorRepository;
    }
    @Autowired
    public void SetTypeRepository(ITypeRepository typeRepository) {
        this.typeRepository=typeRepository;
    }
    @Autowired
    public void SetTypeProductRepository(ITypeProductRepository typeProductRepository) {
        this.typeProductRepository=typeProductRepository;
    }
    @Autowired
    public void SetSizeRepository(ISizeRepository sizeRepository) {
        this.sizeRepository=sizeRepository;
    }

    @Autowired
    public void SetSizeProductRepository(ISizeProductRepository sizeProductRepository) {
        this.sizeProductRepository=sizeProductRepository;
    }

    @Autowired
    public void SetCartRepository(ICartRepository cartRepository) {
        this.cartRepository= cartRepository;
    }


}
