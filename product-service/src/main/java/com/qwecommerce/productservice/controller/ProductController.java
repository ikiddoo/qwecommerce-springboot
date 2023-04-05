package com.qwecommerce.productservice.controller;

import com.qwecommerce.productservice.dto.ProductDTO;
import com.qwecommerce.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() throws Exception {
        try {
            List<ProductDTO> productList = productService.getAllProducts();
            return new ResponseEntity<>(productList, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) throws Exception {
        try {
            int id = productService.addProduct(productDTO);
            String message = "Product " + id + " is added successfully!";
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Integer id) throws Exception {
        try {
            ProductDTO product = productService.getProductById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    @CacheEvict(value="product", key="#id")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Integer id) throws Exception {
        try {
            productService.deleteProductById(id);
            String deleteSuccess = "Product " + id + " is deleted successfully!";
            return new ResponseEntity<>(deleteSuccess, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
