package com.ilnaz.sellerservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class GoodDto {
    private long id;
    private String name;
    private int price;
    private long sellerId;
    private boolean isActive;
    private String goodCategory;
    private long goodCategoryId;
    private String description;
    private List<String> pictureURLs;
}
