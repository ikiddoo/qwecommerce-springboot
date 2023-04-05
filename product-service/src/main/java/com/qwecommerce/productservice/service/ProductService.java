package com.qwecommerce.productservice.service;

import com.qwecommerce.productservice.dto.ProductDTO;
import com.qwecommerce.productservice.exception.ProductServiceException;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts() throws ProductServiceException;

    int addProduct(ProductDTO productDTO);

    ProductDTO getProductById(Integer id) throws ProductServiceException;

    void deleteProductById(Integer id) throws ProductServiceException;
}
