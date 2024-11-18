package com.ilnaz.gateway.controller.impl;

import com.ilnaz.gateway.controller.SellerControllerApi;
import com.ilnaz.gateway.dto.GoodDto;
import com.ilnaz.gateway.dto.SellerServiceResponse;
import com.ilnaz.gateway.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/good")
@RequiredArgsConstructor

public class SellerController implements SellerControllerApi {
    private final SellerService sellerService;


    @Override
    public SellerServiceResponse<GoodDto> createGood(GoodDto goodDto) {
        return sellerService.createGood(goodDto);
    }

    @Override
    public SellerServiceResponse<GoodDto> updateGood(GoodDto goodDto) {
        return sellerService.updateGood(goodDto);
    }

    @Override
    public SellerServiceResponse<Void> deleteGood(long id) {
        return sellerService.deleteGood(id);
    }

    @Override
    public SellerServiceResponse<GoodDto> getGoodById(long id) {
        return sellerService.getGoodById(id);
    }

    @Override
    public SellerServiceResponse<List<GoodDto>> getAllGoods(long sellerId) {
        return sellerService.getAllGoods(sellerId);
    }

    @Override
    public SellerServiceResponse<List<GoodDto>> getGoodsByGroupId(long goodCategoryId) {
        return sellerService.getGoodsByGroupId(goodCategoryId);
    }
}

