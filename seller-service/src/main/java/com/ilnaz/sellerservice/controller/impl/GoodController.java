package com.ilnaz.sellerservice.controller.impl;

import com.ilnaz.sellerservice.controller.GoodApi;
import com.ilnaz.sellerservice.dto.GoodDto;
import com.ilnaz.sellerservice.dto.SellerServiceResponse;
import com.ilnaz.sellerservice.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/good")
@RequiredArgsConstructor
public class GoodController implements GoodApi {
    private final GoodService goodService;

    @Override
    public SellerServiceResponse<GoodDto> createGood(GoodDto goodDto) {
        return goodService.createGood(goodDto);
    }

    @Override
    public SellerServiceResponse<Void> deleteGood(long id) {
        return goodService.deleteGood(id);
    }

    @Override
    public SellerServiceResponse<GoodDto> updateGood(GoodDto goodDto) {
        return goodService.updateGood(goodDto);
    }

    @Override
    public SellerServiceResponse<GoodDto> getGoodById(long id) {
        return goodService.getGoodById(id);
    }

    @Override
    public SellerServiceResponse<List<GoodDto>> getAllGoods(long sellerId) {
        return goodService.getAllGoods(sellerId);
    }

    @Override
    public SellerServiceResponse<List<GoodDto>> getGoodsByGroupId(long goodCategoryId) {
        return goodService.getGoodsByGroupId(goodCategoryId);
    }
}
