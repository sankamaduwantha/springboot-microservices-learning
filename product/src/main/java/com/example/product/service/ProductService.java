package com.example.product.service;

import com.example.product.dto.ProductDto;
import com.example.product.model.ProductModel;
import com.example.product.repo.ProductRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class ProductService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepo productRepo;

    public List<ProductDto> getAllProduct(){
        List<ProductModel> productList = productRepo.findAll();
        return modelMapper.map(productList,new TypeToken<List<ProductDto>>(){}.getType());
    }

    public ProductDto getProductById(Integer productId){
        ProductModel product = productRepo.getProductById(productId);
        return modelMapper.map(product, ProductDto.class);
    }

    public ProductDto saveProduct(ProductDto dto){
        productRepo.save(modelMapper.map(dto, ProductModel.class));
        return dto;
    }

    public ProductDto updateProduct(ProductDto dto){
        productRepo.save(modelMapper.map(dto, ProductModel.class));
        return dto;
    }

    public String deleteProduct(Integer productId) {
        productRepo.deleteById(productId);
        return "product deleted";
    }


}
