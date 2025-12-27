package com.example.product.controller;

import com.example.product.dto.ProductDto;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getallproduct")
    public List<ProductDto> getproduct(){
        return productService.getAllProduct();
    }

    @GetMapping(value ="/product/{productId}")
    public ProductDto getOrderById(@PathVariable Integer productId){
        return productService.getProductById(productId);
    }

    @PostMapping(value = "/saveProduct")
    public ProductDto saveProduct(@RequestBody ProductDto dto){
        return productService.saveProduct(dto);
    }

    @PutMapping(value = "/updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto dto){
        return productService.updateProduct(dto);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {
        return productService.deleteProduct(productId);
    }
}
