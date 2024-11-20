package com.ilnaz.sellerservice.service;


import com.ilnaz.sellerservice.dto.GoodDto;
import com.ilnaz.sellerservice.dto.SellerServiceResponse;
import com.ilnaz.sellerservice.logging.Logging;

import java.util.List;

public interface GoodService {

    @Logging
    SellerServiceResponse<GoodDto> createGood(GoodDto goodDto);

    @Logging
    SellerServiceResponse<Void> deleteGood(long id);

    @Logging
    SellerServiceResponse<GoodDto> getGoodById(long id);

    @Logging
    SellerServiceResponse<GoodDto> updateGood(GoodDto goodDto);

    @Logging
    SellerServiceResponse<List<GoodDto>> getAllGoods(long sellerId);

    @Logging
    SellerServiceResponse<List<GoodDto>> getGoodsByGroupId(long goodCategoryId);
}
