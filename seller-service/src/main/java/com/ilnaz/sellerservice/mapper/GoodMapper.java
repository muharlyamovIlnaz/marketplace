package com.ilnaz.sellerservice.mapper;

import com.ilnaz.sellerservice.dto.GoodDto;
import com.ilnaz.sellerservice.model.GoodEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoodMapper {
    GoodEntity toGoodEntity(GoodDto goodDto);

    GoodDto toGoodDto(GoodEntity goodEntity);

}
