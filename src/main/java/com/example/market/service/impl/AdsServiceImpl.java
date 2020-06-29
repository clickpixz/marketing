package com.example.market.service.impl;

import com.example.market.entity.Ads;
import com.example.market.repository.AdsRepository;
import com.example.market.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdsServiceImpl implements AdsService {

    @Autowired
    private AdsRepository adsRepository;

    @Override
    public Ads createProduct(Ads ads) {
        return adsRepository.save(ads);
    }

    @Override
    public List<Ads> findAll() {
        return adsRepository.findAll();
    }

    @Override
    public Ads updateProduct(Ads ads) {
        return adsRepository.save(ads);
    }

    @Override
    public Optional<Ads> searchAds(Long id) {
        return adsRepository.findById(id);
    }
}
