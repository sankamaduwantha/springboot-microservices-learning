package com.example.order.service;

import com.example.order.model.OrderModel;
import com.example.order.orderDto.OrderDto;
import com.example.order.repo.OrderRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<OrderDto> getAllOrders(){
        List<OrderModel> orderList = orderRepo.findAll();
        return modelMapper.map(orderList,new TypeToken<List<OrderDto>>(){}.getType());
    }

    public OrderDto saveOrder(OrderDto dto){
        orderRepo.save(modelMapper.map(dto, OrderModel.class));
        return dto;
    }
}
