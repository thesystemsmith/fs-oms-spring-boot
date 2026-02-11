package com.fs_oms_spring_boot.order_service.controllers;

import com.fs_oms_spring_boot.order_service.dto.CreateOrderRequest;
import com.fs_oms_spring_boot.order_service.models.Order;
import com.fs_oms_spring_boot.order_service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    //injection
    private final OrderService orderService;

    @Autowired //used for dependency injection
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    //create an order
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
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED); //201 post/put
    }

    // get all orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        //get the data from service
        List<Order> orders = orderService.getAllOrders();

        return new ResponseEntity<>(orders, HttpStatus.OK); //200 put/get/delete/patch
    }

    //get a specific order
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){ //PathVariable- reads value from url / RequestParam - reads query params after ?
        Order order = orderService.getOrderById(id);

        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK); //200
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        }
    }


}
