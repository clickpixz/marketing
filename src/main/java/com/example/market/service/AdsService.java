package com.example.market.service;

import com.example.market.entity.Ads;

import java.util.*;

public interface AdsService {
    Ads createProduct(Ads ads);
    Ads updateProduct(Ads ads);
    List<Ads> findAll();
    Optional<Ads> searchAds(Long id);
//    void deleteUser(Long id);
//    UserPrincipal findByUsername(String username);
}
