package com.fs_oms_spring_boot.order_service.services;

import com.fs_oms_spring_boot.order_service.models.Order;
import com.fs_oms_spring_boot.order_service.persistance.OrderPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OrderService {
    //repo injection
    private final OrderPersistance orderPersistance;

    //constructor
    @Autowired
    public OrderService(OrderPersistance orderPersistance) {
        this.orderPersistance = orderPersistance;
    }

    //create a new order
    public Order createOrder(Long productId, Integer quantity, BigDecimal totalAmount) {
        //generate unique order number
        String orderNumber = generateOrderNumber();

        //create new order object
        Order order = new Order();
        order.setOrderNumber(orderNumber);
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalAmount(totalAmount);
        order.setStatus("PENDING"); // default for new orders

        //save to db
        Order savedOrder = orderPersistance.save(order);
        return savedOrder;
    }


    //gen unique order number
    private String generateOrderNumber() {
        //using uuid to avoid unique constraint error while creating order
        return "ORD-" + java.util.UUID.randomUUID().toString().substring(0,8).toUpperCase();
        
    }
}
