package com.qwecommerce.orderservice;

import com.qwecommerce.orderservice.controller.OrderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
//@WebMvcTest(OrderController.class)
public class TestOrderServices {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void testGetOrderByIdService() throws Exception {
//        this.mockMvc.perform(get("/order/{orderId}", 4).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) content().json("{'orderId':4,'orderDate':'2023-04-02T21:54:48','orderStatus':'PLACED','amount':500.1,'productDetails':{'name':'Vessi Skaters Limited Ed.','id':7,'quantity':0,'price':500.1}}"));
//    }
}
