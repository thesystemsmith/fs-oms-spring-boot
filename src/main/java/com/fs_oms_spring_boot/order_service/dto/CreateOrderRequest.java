package com.fs_oms_spring_boot.order_service.dto;

import java.math.BigDecimal;

// this is what we expect from the client in the request body
public class CreateOrderRequest {
    private Long productId;
    private Integer quantity;
    private BigDecimal totalAmount;

    // def constuctor
    public CreateOrderRequest(){

    }

    // param constructor
    public CreateOrderRequest(Long productId, Integer quantity, BigDecimal totalAmount) {
        this.productId = productId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    // getter and setter
    public  Long getProductId() {
        return  productId;
    }

    public void setProductId(Long productId){
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "CreateOrderRequest{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
