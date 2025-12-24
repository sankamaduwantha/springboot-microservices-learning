package com.example.order.repo;

import com.example.order.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderModel,Integer> {
    @Query(value = "SELECT * FROM  order_model WHERE id=?1", nativeQuery = true)
    OrderModel orderfindbyId(Integer orderId);

}
