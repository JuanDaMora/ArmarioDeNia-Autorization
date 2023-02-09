package com.example.authorization.service.impl;

import com.example.authorization.dto.*;
import com.example.authorization.exception.DataNotFoundException;
import com.example.authorization.exception.TransactionException;
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

    @Override
    public List<ProductDTO> getProducts(){
        List<Product>productList=productRepository.findAll();
        List<ProductDTO> productDTOS=productList.stream()
                .map(ProductMapper.INSTANCE::toProductDTO).collect(Collectors.toList());
        return productDTOS;
    }
    @Override
    public DetailProductDTO getDetailProduct(Long id_product) {

        Product product=productRepository.findById(id_product)
                .orElseThrow((() -> new DataNotFoundException("Product  not found")));
        DetailProductDTO detailProductDTO=ProductMapper.INSTANCE.toDetailProductDTO(product);
        List<ColorProduct> colorList=colorProductRespository.getAllByIdProduct(product.getId());
        List<String> list=new ArrayList<>();
        for(ColorProduct colorProduct:colorList){

            Color color1=colorRepository.findById(colorProduct.getId_color())
                    .orElseThrow((() -> new DataNotFoundException("Color not found")));
            list.add(color1.getDescription());
            detailProductDTO.setColor_product(list);
        }
        list=new ArrayList<>();
        List<TypeProduct> typeProducts=typeProductRepository.getAllByIdProduct(product.getId());
        for(TypeProduct typeProduct:typeProducts){

            Type type=typeRepository.findById(typeProduct.getId_types())
                    .orElseThrow((() -> new DataNotFoundException("Type not found")));
            list.add(type.getDescription());
            detailProductDTO.setType_product(list);
        }
        list=new ArrayList<>();
        List<SizeProduct> sizeProducts=sizeRepository.getAllByIdProduct(product.getId());
        for(SizeProduct sizeProduct:sizeProducts){

            Size size=sizeRepository.findById(sizeProduct.getId_size())
                    .orElseThrow((() -> new DataNotFoundException("Size not found")));
            list.add(size.getDescription());
            detailProductDTO.setSize_product(list);
        }
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



}
