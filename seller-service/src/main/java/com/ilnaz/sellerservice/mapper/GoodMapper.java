package com.ilnaz.sellerservice.mapper;

import com.ilnaz.sellerservice.dto.GoodDto;
import com.ilnaz.sellerservice.logging.Logging;
import com.ilnaz.sellerservice.model.GoodEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoodMapper {

    @Logging
    GoodEntity toGoodEntity(GoodDto goodDto);

    @Logging
    GoodDto toGoodDto(GoodEntity goodEntity);

}
