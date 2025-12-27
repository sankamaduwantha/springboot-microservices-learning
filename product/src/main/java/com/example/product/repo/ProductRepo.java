package com.example.product.repo;

import com.example.product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepo extends JpaRepository<ProductModel, Integer> {
   @Query(value = "SELECT * FROM product_model WHERE id=?1 ",nativeQuery = true)
    ProductModel getProductById(Integer productId);
}
