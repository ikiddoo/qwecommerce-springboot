package com.qwecommerce.productservice.service;

import com.qwecommerce.productservice.dto.ProductDTO;
import com.qwecommerce.productservice.entity.Product;
import com.qwecommerce.productservice.exception.ProductServiceException;
import com.qwecommerce.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Cacheable(value="product")
    public List<ProductDTO> getAllProducts() throws ProductServiceException {
        LOGGER.info("View All Products is called.");
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty()) {
            throw new ProductServiceException("There are no products to retrieve!");
        }
        List<ProductDTO> productDTOList = productList.stream().map(product ->
                new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getQuantity())).collect(Collectors.toList());
        LOGGER.info("Get All Products success!");
        return productDTOList;
    }

    @Override
    public int addProduct(ProductDTO productDTO) {
        LOGGER.info("Add product is called.");
        Product product = new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getQuantity());
        product = productRepository.save(product);
        LOGGER.info("Add product success! Product Id: " + product.getId());
        return product.getId();
    }

    @Override
    @Cacheable(value="product", key="#id")
    public ProductDTO getProductById(Integer id) throws ProductServiceException {
        LOGGER.info("Get Product By Id is called. Get product for id: {}", id);
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ProductServiceException("Product " + id + " is not found!"));
        ProductDTO productDTO = new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getQuantity());
        copyProperties(product, productDTO);
        LOGGER.info("Get Product By Id success! " + productDTO);
        return productDTO;
    }

    @Override
    @CacheEvict(value="product", key="#id")
    public void deleteProductById(Integer id) throws ProductServiceException {
        LOGGER.info("Delete product is called. To delete id: {}", id);
        if (!productRepository.existsById(id)) {
            throw new ProductServiceException("Product id: " + id + " is not found!");
        }
        LOGGER.info("Deleting product id {}", id);
        productRepository.deleteById(id);
        LOGGER.info("Delete product id {} success!", id);
    }
}
