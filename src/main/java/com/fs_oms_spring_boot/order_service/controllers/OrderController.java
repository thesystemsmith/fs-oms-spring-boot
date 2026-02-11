package com.fs_oms_spring_boot.order_service.controllers;

import com.fs_oms_spring_boot.order_service.dto.CreateOrderRequest;
import com.fs_oms_spring_boot.order_service.models.Order;
import com.fs_oms_spring_boot.order_service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    //injection
    private final OrderService orderService;

    @Autowired //used for dependency injection
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    // access responseType functionName ( dto requestBody)
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request){
        //call the service to create an order
        Order createdOrder = orderService.createOrder(
                request.getProductId(),
                request.getQuantity(),
                request.getTotalAmount()
        );

        //response
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED); //201
    }
}
