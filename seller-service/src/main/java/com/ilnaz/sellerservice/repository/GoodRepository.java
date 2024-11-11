package com.ilnaz.sellerservice.repository;


import com.ilnaz.sellerservice.model.GoodEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodRepository extends CrudRepository<GoodEntity, Long> {
    List<GoodEntity> findAllBySellerId(Long sellerId);

    List<GoodEntity> findAllByGoodCategoryId(Long goodCategoryId);

}
