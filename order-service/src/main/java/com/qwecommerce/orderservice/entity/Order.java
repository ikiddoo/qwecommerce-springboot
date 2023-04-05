package com.qwecommerce.orderservice.entity;

import com.qwecommerce.orderservice.dto.PaymentMode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "order_quantity")
    private int orderQuantity;
    @Column(name = "order_status")
    private String orderStatus;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "order_total_amount")
    private float orderTotalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_payment_mode")
    private PaymentMode paymentMode;

    public Order() {

    }

    public Order(int productId, int orderQuantity, String orderStatus, LocalDateTime orderDate, float orderTotalAmount, PaymentMode paymentMode) {
        this.productId = productId;
        this.orderQuantity = orderQuantity;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.orderTotalAmount = orderTotalAmount;
        this.paymentMode = paymentMode;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public float getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(float orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
