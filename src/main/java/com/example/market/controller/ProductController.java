package com.example.market.controller;

import com.example.market.entity.Product;
import com.example.market.entity.User;
import com.example.market.message.APIResponse;
import com.example.market.message.APISuccReponse;
import com.example.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public APIResponse createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new APISuccReponse().emptyBody().withMessage("Success");
    }

    @PutMapping("/updateProduct")
    public APIResponse updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return new APISuccReponse().emptyBody().withMessage("Success");
    }

    @PostMapping("/searchProduct/{id}")
    public APIResponse searchUser(@RequestBody @PathVariable("id") Long id) {
        Optional<Product> product=productService.searchProduct(id);
        return new APISuccReponse().withBody(product).withMessage("Success");
    }

    @GetMapping("/getAllProduct")
    public APIResponse getAllProduct() {
        return new APISuccReponse().withBody( productService.findAll()).withMessage("Success");
    }
}
