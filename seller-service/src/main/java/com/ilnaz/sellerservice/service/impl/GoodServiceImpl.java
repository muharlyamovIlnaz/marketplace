package com.ilnaz.sellerservice.service.impl;


import com.ilnaz.sellerservice.dto.GoodDto;
import com.ilnaz.sellerservice.dto.SellerServiceResponse;
import com.ilnaz.sellerservice.mapper.GoodMapper;
import com.ilnaz.sellerservice.model.GoodEntity;
import com.ilnaz.sellerservice.repository.GoodRepository;
import com.ilnaz.sellerservice.service.GoodService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoodServiceImpl implements GoodService {
    private final GoodRepository goodRepository;
    private final GoodMapper goodMapper;

    @Override
    public SellerServiceResponse<GoodDto> createGood(GoodDto goodDto) {
        GoodEntity goodEntity = goodMapper.toGoodEntity(goodDto);
        goodEntity = goodRepository.save(goodEntity);
        return SellerServiceResponse.ok("Good created", goodMapper.toGoodDto(goodEntity));
    }

    @Override
    public SellerServiceResponse<Void> deleteGood(long id) {
        if (!goodRepository.existsById(id)) {
            return SellerServiceResponse.notFoundError("Good by ID " + id + " was not found");
        }
        try {
            goodRepository.deleteById(id);
            return SellerServiceResponse.ok("Good by ID " + id + " was deleted");
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при удалении товара с ID " + id, e);
        }
    }

    @Override
    public SellerServiceResponse<GoodDto> getGoodById(long id) {
        GoodEntity goodEntity = goodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Товар не найден."));
        return SellerServiceResponse.ok("Good by " + id + " was found", goodMapper.toGoodDto(goodEntity));
    }

    @Override
    public SellerServiceResponse<GoodDto> updateGood(GoodDto goodDto) {
        GoodEntity goodEntity = goodMapper.toGoodEntity(goodDto);
        GoodEntity updatedEntity = goodRepository.save(goodEntity);
        GoodDto updatedDto = goodMapper.toGoodDto(updatedEntity);

        return SellerServiceResponse.ok("Good by " + updatedEntity.getId() + " was update", updatedDto);
    }


    @Override
    public SellerServiceResponse<List<GoodDto>> getAllGoods(long sellerId) {
        List<GoodEntity> allGoodEntity = goodRepository.findAllBySellerId(sellerId);
        if (allGoodEntity.isEmpty()) {
            return SellerServiceResponse.notFoundError("No goods found for seller ID " + sellerId, List.of());
        }
        return SellerServiceResponse.ok("Goods by " + sellerId + " was found", allGoodEntity.stream()
                .map(goodMapper::toGoodDto)
                .collect(Collectors.toList()));
    }

    @Override
    public SellerServiceResponse<List<GoodDto>> getGoodsByGroupId(long goodCategoryId) {
        List<GoodEntity> allGoodEntity = goodRepository.findAllByGoodCategoryId(goodCategoryId);
        if (allGoodEntity.isEmpty()) {
            return SellerServiceResponse.notFoundError("No goods found for category ID " + goodCategoryId, List.of());
        }
        return SellerServiceResponse.ok("Goods by groupID " + goodCategoryId + " was found", allGoodEntity.stream()
                .map(goodMapper::toGoodDto)
                .collect(Collectors.toList()));
    }

}
