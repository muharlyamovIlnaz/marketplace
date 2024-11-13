package com.ilnaz.sellerservice.service;


import com.ilnaz.sellerservice.dto.GoodDto;
import com.ilnaz.sellerservice.dto.SellerServiceResponse;

import java.util.List;

public interface GoodService {
    SellerServiceResponse<GoodDto> createGood(GoodDto goodDto);

    SellerServiceResponse<Void> deleteGood(long id);

    SellerServiceResponse<GoodDto> getGoodById(long id);

    SellerServiceResponse<GoodDto> updateGood(GoodDto goodDto);

    SellerServiceResponse<List<GoodDto>> getAllGoods(long sellerId);

    SellerServiceResponse<List<GoodDto>> getGoodsByGroupId(long goodCategoryId);
}
