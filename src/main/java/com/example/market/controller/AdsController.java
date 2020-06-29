package com.example.market.controller;

import com.example.market.entity.Ads;
import com.example.market.entity.Product;
import com.example.market.message.APIResponse;
import com.example.market.message.APISuccReponse;
import com.example.market.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class AdsController {
    @Autowired
    private AdsService adsService;

    @PostMapping("/createAds")
    public APIResponse createProduct(@RequestBody Ads ads) {
        adsService.createProduct(ads);
        return new APISuccReponse().emptyBody().withMessage("Success");
    }

    @PutMapping("/updateAds")
    public APIResponse updateProduct(@RequestBody Ads ads) {
        adsService.updateProduct(ads);
        return new APISuccReponse().emptyBody().withMessage("Success");
    }

    @PostMapping("/searchAds/{id}")
    public APIResponse searchUser(@RequestBody @PathVariable("id") Long id) {
        Optional<Ads> ads=adsService.searchAds(id);
        return new APISuccReponse().withBody(ads).withMessage("Success");
    }

    @GetMapping("/getAllAds")
    public APIResponse getAllProduct() {
        return new APISuccReponse().withBody( adsService.findAll()).withMessage("Success");
    }
}
