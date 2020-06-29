package com.example.market.repository;

import com.example.market.entity.Ads;
import com.example.market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdsRepository extends JpaRepository<Ads, Long> {

}
