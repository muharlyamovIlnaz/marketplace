package com.ilnaz.sellerservice.service.impl;


import com.ilnaz.sellerservice.dto.GoodDto;
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
    public GoodDto createGood(GoodDto goodDto) {
        GoodEntity goodEntity = goodMapper.toGoodEntity(goodDto);
        goodEntity = goodRepository.save(goodEntity);
        return goodMapper.toGoodDto(goodEntity);
    }

    @Override
    public boolean deleteGood(long id) {
        try {
            if (!goodRepository.existsById(id)) {
                throw new EntityNotFoundException("Товар с ID " + id + " не найден.");
            }
            goodRepository.deleteById(id);
            return true;
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при удалении товара с ID " + id, e);
        }
    }

    @Override
    public GoodDto getGoodById(long id) {
        GoodEntity goodEntity = goodRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Товар не найден."));
        return goodMapper.toGoodDto(goodEntity);
    }

    @Override
    public GoodDto updateGood(GoodDto goodDto) {
        GoodEntity goodEntity = goodMapper.toGoodEntity(goodDto);
        goodRepository.save(goodEntity);
        return goodMapper.toGoodDto(goodRepository.findById(goodEntity.getId()).orElseThrow(() -> new EntityNotFoundException("Товар не найден.")));
    }

    @Override
    public List<GoodDto> getAllGoods(long sellerId) {
        List<GoodEntity> allGoodEntity = goodRepository.findAllBySellerId(sellerId);
        return allGoodEntity.stream()
                .map(goodMapper::toGoodDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GoodDto> getGoodsByGroupId(long goodCategoryId) {
        List<GoodEntity> allGoodEntity = goodRepository.findAllByGoodCategoryId(goodCategoryId);
        return allGoodEntity.stream()
                .map(goodMapper::toGoodDto)
                .collect(Collectors.toList());
    }
}
