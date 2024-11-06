package com.ilnaz.sellerservice.controller.impl;

import com.ilnaz.sellerservice.controller.GoodApi;
import com.ilnaz.sellerservice.dto.GoodDto;
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
    public GoodDto createGood(GoodDto goodDto) {
        return goodService.createGood(goodDto);
    }

    @Override
    public boolean deleteGood(long id) {
        return goodService.deleteGood(id);
    }

    @Override
    public GoodDto updateGood(GoodDto goodDto) {
        return goodService.updateGood(goodDto);
    }

    @Override
    public GoodDto getGoodById(long id) {
        return goodService.getGoodById(id);
    }

    @Override
    public List<GoodDto> getAllGoods(long sellerId) {
        return goodService.getAllGoods(sellerId);
    }

    @Override
    public List<GoodDto> getGoodsByGroupId(long goodCategoryId) {
        return goodService.getGoodsByGroupId(goodCategoryId);
    }
}
