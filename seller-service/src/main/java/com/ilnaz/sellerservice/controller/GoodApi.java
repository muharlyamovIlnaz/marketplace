package com.ilnaz.sellerservice.controller;


import com.ilnaz.sellerservice.dto.GoodDto;
import com.ilnaz.sellerservice.dto.SellerServiceResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/good")
@Tag(name = "GoodController")
public interface GoodApi {

    @PostMapping
    SellerServiceResponse createGood(@RequestBody GoodDto goodDto);


    @DeleteMapping("/{id}")
    SellerServiceResponse deleteGood(@PathVariable(name = "id") long id);


    @PatchMapping
    SellerServiceResponse updateGood(@RequestBody GoodDto goodDto);


    @GetMapping("/{id}")
    SellerServiceResponse getGoodById(@PathVariable(name = "id") long id);


    @GetMapping("/seller/{id}")
    SellerServiceResponse getAllGoods(@PathVariable(name = "id") long sellerId);


    @GetMapping("/group/{id}")
    SellerServiceResponse getGoodsByGroupId(@PathVariable(name = "id") long goodCategoryId);

}
