package com.qwecommerce.orderservice.service;

import com.qwecommerce.orderservice.dto.OrderRequestDTO;
import com.qwecommerce.orderservice.dto.OrderResponseDTO;
import com.qwecommerce.orderservice.dto.ProductDetails;
import com.qwecommerce.orderservice.entity.Order;
import com.qwecommerce.orderservice.exception.OrderServiceException;
import com.qwecommerce.orderservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public int orderProduct(OrderRequestDTO orderRequestDTO) {
        // create order service
        LocalDateTime orderDate = LocalDateTime.now();
        String orderStatus = "CREATED";
        Order order = new Order(orderRequestDTO.getProductId(), orderRequestDTO.getQuantity(), orderStatus, orderDate, orderRequestDTO.getTotalAmount(), orderRequestDTO.getPaymentMode());
        order = orderRepository.save(order);
        try {
            orderStatus = "PLACED";
        } catch (Exception e) {
            orderStatus = "FAILED";
        }
        order.setOrderStatus(orderStatus); // update order status
        orderRepository.save(order);
        return order.getOrderId();
    }

    @Override
    public OrderResponseDTO getOrderById(int orderId) throws OrderServiceException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(headers);
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderServiceException("Order id not found: " + orderId));
        System.out.println(order);
        ResponseEntity<ProductDetails> responseProductDetails = restTemplate.exchange(
                "http://PRODUCT-SERVICE/product/" + order.getProductId(),
                HttpMethod.GET, request, ProductDetails.class
        );
        ProductDetails productDetails = responseProductDetails.getBody();
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO(
                order.getOrderId(), order.getOrderDate(), order.getOrderStatus(), order.getOrderTotalAmount(),
                new ProductDetails(productDetails.getName(), productDetails.getId(), productDetails.getPrice())
        );
        return orderResponseDTO;
    }
}
