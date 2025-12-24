package com.example.order.controller;

import com.example.order.orderDto.OrderDto;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1")

public class OrderController {
    @Autowired
    public OrderService orderService;

    @GetMapping("/getallorders")
    public List<OrderDto> getorder(){
        return orderService.getAllOrders();
    }

    @GetMapping(value ="/order/{orderId}")
    public OrderDto getOrderById(@PathVariable Integer orderId){
        return orderService.getOrderById(orderId);
    }

    @PostMapping(value = "/saveOrder")
    public OrderDto saveOrder(@RequestBody OrderDto dto){
        return orderService.saveOrder(dto);
    }

    @PutMapping(value = "/updateOrder")
    public OrderDto updateItems(@RequestBody OrderDto dto){
        return orderService.updateOrder(dto);
    }

    @DeleteMapping("/deleteorder/{orderId}")
    public String deleteOrder(@PathVariable Integer orderId) {
        return orderService.deleteOrder(orderId);
    }
}
