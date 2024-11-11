package com.ilnaz.sellerservice.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "good")
public class GoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "seller_id")
    private long sellerId;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "good_category")
    private String goodCategory;

    @Column(name = "good_category_id")
    private long goodCategoryId;

    @Column(name = "description")
    private String description;

    @Column(name = "picture_urls")
    private List<String> pictureURLs;
}
