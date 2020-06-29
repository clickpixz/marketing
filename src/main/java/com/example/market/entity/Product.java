package com.example.market.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name="product")
@Getter
@Setter
public class Product extends BaseEntity{
    private String name;
    private Integer price;
    private String descibe;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<ProductCompete> productCompetes;
}
