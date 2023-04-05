package com.qwecommerce.orderservice.controller;

import com.qwecommerce.orderservice.dto.OrderRequestDTO;
import com.qwecommerce.orderservice.dto.OrderResponseDTO;
import com.qwecommerce.orderservice.exception.OrderServiceException;
import com.qwecommerce.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping("/place-order")
    public ResponseEntity<Integer> orderProduct(@RequestBody OrderRequestDTO orderRequest) {
        int orderId;
        LOGGER.info("OrderController(placeOrder): is called!");
        LOGGER.info("OrderController(placeOrder): (orderRequest): {}", orderRequest.toString());
        try {
            orderId = orderService.orderProduct(orderRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("OrderController (orderId): {}", orderId);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }

    @GetMapping(value="/{orderId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable("orderId") Integer orderId) throws OrderServiceException {
        System.out.println(orderId);
        LOGGER.info("OrderController(getOrderDetails): getOrderDetails is called!");
        try {
            OrderResponseDTO orderResponseDTO = orderService.getOrderById(orderId);
            return new ResponseEntity<>(new OrderResponseDTO(
                    orderResponseDTO.getOrderId(),
                    orderResponseDTO.getOrderDate(),
                    orderResponseDTO.getOrderStatus(),
                    orderResponseDTO.getAmount(),
                    orderResponseDTO.getProductDetails()), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
