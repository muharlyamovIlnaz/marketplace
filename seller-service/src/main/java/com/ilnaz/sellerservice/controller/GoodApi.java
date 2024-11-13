package com.ilnaz.sellerservice.controller;


import com.ilnaz.sellerservice.dto.GoodDto;
import com.ilnaz.sellerservice.dto.SellerServiceResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/good")
@Tag(name = "GoodController")
public interface GoodApi {

    @PostMapping
    SellerServiceResponse<GoodDto> createGood(@RequestBody GoodDto goodDto);


    @DeleteMapping("/{id}")
    SellerServiceResponse<Void> deleteGood(@PathVariable(name = "id") long id);


    @PutMapping
    SellerServiceResponse<GoodDto> updateGood(@RequestBody GoodDto goodDto);


    @GetMapping("/{id}")
    SellerServiceResponse<GoodDto> getGoodById(@PathVariable(name = "id") long id);


    @GetMapping("/seller/{id}")
    SellerServiceResponse<List<GoodDto>> getAllGoods(@PathVariable(name = "id") long sellerId);


    @GetMapping("/group/{id}")
    SellerServiceResponse<List<GoodDto>> getGoodsByGroupId(@PathVariable(name = "id") long goodCategoryId);

}
