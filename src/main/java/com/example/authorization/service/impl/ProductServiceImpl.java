package com.example.authorization.service.impl;

import com.example.authorization.dto.*;
import com.example.authorization.model.*;
import com.example.authorization.repository.*;
import com.example.authorization.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
public class ProductServiceImpl implements IProductService {
    private IProductRepository productRepository;
    private IColorProductRespository colorProductRespository;
    private ITypeProductRepository typeProductRepository;
    private ISizeRepository sizeRepository;
    private IColorRepository colorRepository;
    private ITypeRepository typeRepository;
    private ISizeProductRepository sizeProductRepository;
    @Override
    public List<DetailProductDTO> getDetailProducts() {
        List<Product> listProduct = getAllProducts();
        List<SizeProduct> listsizeProduct= getAllSizeProducts();
        List<ColorProduct>  listColorProduct= getAllColorProducts();
        List<TypeProduct> listTYpeProduct=getAllTypeProducts();

        List<DetailProductDTO> resul =  new ArrayList<DetailProductDTO>();
        for (Product newList:listProduct){
            DetailProductDTO detailProductDTO=new DetailProductDTO();
            detailProductDTO.setId_product(newList.getId());
            detailProductDTO.setAmount(newList.getAmount());
            detailProductDTO.setDescription(newList.getDescription());
            detailProductDTO.setIs_for_womans(newList.getIs_for_womans());
            detailProductDTO.setPrice(newList.getPrice());
            List<String> list=new ArrayList<String>();
            for(SizeProduct newList2:listsizeProduct){
                if(newList.getId().equals(newList2.getId_product())){
                    Size size= sizeRepository.getReferenceById(newList2.getId_size());
                    list.add(size.getDescription());
                    detailProductDTO.setSize_product(list);
                }
            }
            List<String> list2=new ArrayList<String>();
            for(ColorProduct newList3:listColorProduct){
                if(newList.getId().equals(newList3.getId_product())){
                    Color color= colorRepository.getReferenceById(newList3.getId_color());
                    list2.add(color.getDescription());
                    detailProductDTO.setColor_product(list2);
                }
            }
            List<String> list3=new ArrayList<String>();
            for(TypeProduct newList4:listTYpeProduct){
                if(newList.getId().equals(newList4.getId_product())){
                    Type type= typeRepository.getReferenceById(newList4.getId_types());
                    list3.add(type.getDescription());
                    detailProductDTO.setType_product(list3);
                }
            }

            resul.add(detailProductDTO);
        }
        resul=resul;
        return resul;
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public List<SizeProduct> getAllSizeProducts() {
        return sizeProductRepository.findAll();
    }

    @Override
    public List<ColorProduct> getAllColorProducts() {
        return colorProductRespository.findAll();
    }
    @Override
    public List<TypeProduct> getAllTypeProducts() {
        return typeProductRepository.findAll();
    }



    @Autowired
    public void SetProductRepository(IProductRepository ProductRespository) {
        this.productRepository=ProductRespository;
    }

    @Autowired
    public void SetSizeRepository(ISizeRepository sizeRepository) {
        this.sizeRepository =sizeRepository;
    }
    @Autowired
    public void SetColorRepository(IColorRepository colorRepository) {
        this.colorRepository =colorRepository;
    }
    @Autowired
    public void SetTypeRepository(ITypeRepository typeRepository) {
        this.typeRepository =typeRepository;
    }
    @Autowired
    public void SetSizeProductRepository(ISizeProductRepository sizeProductRepository) {
        this.sizeProductRepository =sizeProductRepository;
    }
    @Autowired
    public void SetColorProductRepository(IColorProductRespository colorProductRepository) {
        this.colorProductRespository =colorProductRepository;
    }
    @Autowired
    public void SetTypeProductRepository(ITypeProductRepository typeProductRepository) {
        this.typeProductRepository =typeProductRepository;
    }

}
