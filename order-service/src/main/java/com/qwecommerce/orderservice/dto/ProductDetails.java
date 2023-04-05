package com.qwecommerce.orderservice.dto;

public class ProductDetails {

    private String name;
    private int id;
    private int quantity;
    private float price;

    public ProductDetails() {

    }

    public ProductDetails(String name, int id, float price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public ProductDetails(String productName, int productId, int quantity, float price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
