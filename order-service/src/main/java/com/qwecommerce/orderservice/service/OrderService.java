package com.qwecommerce.orderservice.service;

import com.qwecommerce.orderservice.dto.OrderRequestDTO;
import com.qwecommerce.orderservice.dto.OrderResponseDTO;
import com.qwecommerce.orderservice.exception.OrderServiceException;

public interface OrderService {
    int orderProduct(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO getOrderById(int orderId) throws OrderServiceException;
}
