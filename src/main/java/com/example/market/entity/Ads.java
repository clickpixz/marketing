package com.example.market.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ads")
@Getter
@Setter
public class Ads extends BaseEntity{
    private String name;
    private String socialnetwork;
    private String view;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
