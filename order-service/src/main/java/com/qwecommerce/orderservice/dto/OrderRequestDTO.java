package com.qwecommerce.orderservice.dto;

public class OrderRequestDTO {
    private int productId; // product id
    private float totalAmount;
    private int quantity;
    private PaymentMode paymentMode;

    public OrderRequestDTO() { }

    public OrderRequestDTO(int productId, float totalAmount, int quantity, PaymentMode paymentMode) {
        this.productId = productId;
        this.totalAmount = totalAmount;
        this.quantity = quantity;
        this.paymentMode = paymentMode;
    }

    public int getProductId() {
        return productId;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public int getQuantity() {
        return quantity;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }
}
