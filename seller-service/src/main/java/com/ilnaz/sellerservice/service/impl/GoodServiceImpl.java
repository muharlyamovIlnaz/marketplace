package com.ilnaz.sellerservice.service.impl;


import com.ilnaz.sellerservice.dto.GoodDto;
import com.ilnaz.sellerservice.dto.SellerServiceResponse;
import com.ilnaz.sellerservice.mapper.GoodMapper;
import com.ilnaz.sellerservice.model.GoodEntity;
import com.ilnaz.sellerservice.repository.GoodRepository;
import com.ilnaz.sellerservice.service.GoodService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoodServiceImpl implements GoodService {
    private final GoodRepository goodRepository;
    private final GoodMapper goodMapper;

    @Override
    public SellerServiceResponse createGood(GoodDto goodDto) {
        GoodEntity goodEntity = goodMapper.toGoodEntity(goodDto);
        goodEntity = goodRepository.save(goodEntity);
        return getSellerServiceResponse("Good created", goodMapper.toGoodDto(goodEntity));

    }

    @Override
    public SellerServiceResponse deleteGood(long id) {
        if (!goodRepository.existsById(id)) {
            return getSellerServiceResponse("Good by ID " + id + " was not found");
        }

        try {
            goodRepository.deleteById(id);
            return getSellerServiceResponse("Good by ID " + id + " was deleted");
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при удалении товара с ID " + id, e);
        }
    }

    @Override
    public SellerServiceResponse getGoodById(long id) {
        GoodEntity goodEntity = goodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Товар не найден."));
        return SellerServiceResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Good by " + id + " was found")
                .body(goodMapper.toGoodDto(goodEntity)).build();
    }

    @Override
    public SellerServiceResponse updateGood(GoodDto goodDto) {
        GoodEntity goodEntity = goodMapper.toGoodEntity(goodDto);
        goodRepository.save(goodEntity);
        GoodDto goodDto1 = goodMapper.toGoodDto(goodRepository.findById(goodEntity.getId()).
                orElseThrow(() -> new EntityNotFoundException("Товар не найден.")));
        return getSellerServiceResponse("Good by " + goodEntity.getId() + " was update", goodDto1);

    }

    @Override
    public SellerServiceResponse getAllGoods(long sellerId) {
        List<GoodEntity> allGoodEntity = goodRepository.findAllBySellerId(sellerId);
        if (allGoodEntity.isEmpty()) {
            return getSellerServiceResponse("No goods found for seller ID " + sellerId);
        }
        return getSellerServiceResponse("Goods by " + sellerId + " was found", allGoodEntity.stream()
                .map(goodMapper::toGoodDto)
                .collect(Collectors.toList()));
    }

    @Override
    public SellerServiceResponse getGoodsByGroupId(long goodCategoryId) {
        List<GoodEntity> allGoodEntity = goodRepository.findAllByGoodCategoryId(goodCategoryId);
        if (allGoodEntity.isEmpty()) {
            return getSellerServiceResponse("No goods found for category ID " + goodCategoryId);
        }
        return getSellerServiceResponse("Goods by groupID " + goodCategoryId + " was found", allGoodEntity.stream()
                .map(goodMapper::toGoodDto)
                .collect(Collectors.toList()));
    }

    private SellerServiceResponse getSellerServiceResponse(String message, Object body) {
        return SellerServiceResponse.builder()
                .status(HttpStatus.OK.value())
                .message(message)
                .body(body)
                .build();
    }

    private SellerServiceResponse getSellerServiceResponse(String message) {
        return SellerServiceResponse.builder()
                .status(HttpStatus.OK.value())
                .message(message)
                .build();
    }
}
