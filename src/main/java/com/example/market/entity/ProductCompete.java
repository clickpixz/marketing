package com.example.market.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productcompetion")
@Getter
@Setter
public class ProductCompete extends BaseEntity{
    private String name;
    private Integer price;
    private String company;
    private String descibe;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
