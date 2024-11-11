package com.ilnaz.sellerservice.service;


import com.ilnaz.sellerservice.dto.GoodDto;
import com.ilnaz.sellerservice.dto.SellerServiceResponse;

public interface GoodService {
    SellerServiceResponse createGood(GoodDto goodDto);

    SellerServiceResponse deleteGood(long id);

    SellerServiceResponse getGoodById(long id);

    SellerServiceResponse updateGood(GoodDto goodDto);

    SellerServiceResponse getAllGoods(long sellerId);

    SellerServiceResponse getGoodsByGroupId(long goodCategoryId);
}
