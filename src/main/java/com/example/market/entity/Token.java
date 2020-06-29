package com.example.market.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "token")
@Getter
@Setter
public class Token extends BaseEntity{

    @Column(length = 1000)
    private String token;
    private Date tokenexpdate;

}
