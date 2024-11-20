package com.ilnaz.gateway.controller;


import com.ilnaz.gateway.dto.GoodDto;
import com.ilnaz.gateway.dto.SellerServiceResponse;
import com.ilnaz.gateway.logging.Logging;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/good")
@Tag(name = "SellerController")
public interface SellerControllerApi {

    @Logging
    @PreAuthorize("hasRole('ROLE_SELLER')")
    @PostMapping
    SellerServiceResponse<GoodDto> createGood(@RequestBody GoodDto goodDto);

    @Logging
    @PreAuthorize("hasRole('ROLE_SELLER')")
    @PutMapping
    SellerServiceResponse<GoodDto> updateGood(@RequestBody GoodDto goodDto);

    @Logging
    @PreAuthorize("hasRole('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    SellerServiceResponse<Void> deleteGood(@PathVariable(name = "id") long id);

    @Logging
    @PreAuthorize("hasRole('ROLE_SELLER')")
    @GetMapping("/{id}")
    SellerServiceResponse<GoodDto> getGoodById(@PathVariable(name = "id") long id);

    @Logging
    @PreAuthorize("hasRole('ROLE_SELLER')")
    @GetMapping("/seller/{id}")
    SellerServiceResponse<List<GoodDto>> getAllGoods(@PathVariable(name = "id") long sellerId);

    @Logging
    @PreAuthorize("hasRole('ROLE_SELLER')")
    @GetMapping("/group/{id}")
    SellerServiceResponse<List<GoodDto>> getGoodsByGroupId(@PathVariable(name = "id") long goodCategoryId);
}