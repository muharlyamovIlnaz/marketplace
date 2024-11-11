package com.ilnaz.sellerservice.controller.impl;

import com.ilnaz.sellerservice.controller.GoodApi;
import com.ilnaz.sellerservice.dto.GoodDto;
import com.ilnaz.sellerservice.dto.SellerServiceResponse;
import com.ilnaz.sellerservice.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/good")
@RequiredArgsConstructor
public class GoodController implements GoodApi {
    private final GoodService goodService;

    @Override
    public SellerServiceResponse createGood(GoodDto goodDto) {
        return goodService.createGood(goodDto);
    }

    @Override
    public SellerServiceResponse deleteGood(long id) {
        return goodService.deleteGood(id);
    }

    @Override
    public SellerServiceResponse updateGood(GoodDto goodDto) {
        return goodService.updateGood(goodDto);
    }

    @Override
    public SellerServiceResponse getGoodById(long id) {
        return goodService.getGoodById(id);
    }

    @Override
    public SellerServiceResponse getAllGoods(long sellerId) {
        return goodService.getAllGoods(sellerId);
    }

    @Override
    public SellerServiceResponse getGoodsByGroupId(long goodCategoryId) {
        return goodService.getGoodsByGroupId(goodCategoryId);
    }
}
