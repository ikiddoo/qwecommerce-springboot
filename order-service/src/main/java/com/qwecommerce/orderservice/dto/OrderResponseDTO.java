package com.qwecommerce.orderservice.dto;

import java.time.LocalDateTime;

public class OrderResponseDTO {

    private int orderId;
    private LocalDateTime orderDate;
    private String orderStatus;
    private float amount;
    private ProductDetails productDetails;


    public OrderResponseDTO() {

    }

    public OrderResponseDTO(int orderId, LocalDateTime orderDate, String orderStatus, float amount, ProductDetails productDetails) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.amount = amount;
        this.productDetails = productDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public float getAmount() {
        return amount;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }
}
