package com.ilnaz.sellerservice.service;


import com.ilnaz.sellerservice.dto.GoodDto;

import java.util.List;

public interface GoodService {
    GoodDto createGood(GoodDto goodDto);

    boolean deleteGood(long id);

    GoodDto getGoodById(long id);

    GoodDto updateGood(GoodDto goodDto);

    List<GoodDto> getAllGoods(long sellerId);

    List<GoodDto> getGoodsByGroupId(long goodCategoryId);
}
