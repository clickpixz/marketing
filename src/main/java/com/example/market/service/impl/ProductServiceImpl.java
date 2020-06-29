package com.example.market.service.impl;

import com.example.market.entity.Product;
import com.example.market.entity.User;
import com.example.market.repository.*;
import com.example.market.security.UserPrincipal;
import com.example.market.service.ProductService;
import com.example.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> searchProduct(Long id) {
        return productRepository.findById(id);
    }
}
