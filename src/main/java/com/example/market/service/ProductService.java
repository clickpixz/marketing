package com.example.market.service;

import com.example.market.entity.Product;
import com.example.market.entity.User;
import com.example.market.security.UserPrincipal;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    List<Product> findAll();
    Optional<Product> searchProduct(Long id);
//    void deleteUser(Long id);
//    UserPrincipal findByUsername(String username);
}
