package com.example.market.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role extends BaseEntity {
    private String role_name;
}
