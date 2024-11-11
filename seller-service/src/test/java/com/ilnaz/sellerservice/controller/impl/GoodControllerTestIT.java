package com.ilnaz.sellerservice.controller.impl;

import com.ilnaz.sellerservice.dto.GoodDto;
import com.ilnaz.sellerservice.model.GoodEntity;
import com.ilnaz.sellerservice.repository.GoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GoodControllerTestIT {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private GoodRepository goodRepository;

    @Test
    void createGood() {
    }

    @Test
    void deleteGood() {
        
    }

    @Test
    void updateGood() throws Exception {
        // given
        GoodEntity entity = getNewEntity();

        GoodDto goodDto = new GoodDto();
        goodDto.setId(1);
        goodDto.setName("Товар1");
        goodDto.setPrice(100);
        goodDto.setActive(true);

        when(goodRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(goodRepository.save(entity)).thenReturn(entity);

        // Convert goodDto to JSON format
        String goodDtoJson = "{ \"id\": 1, \"name\": \"Товар1\", \"price\": 100, \"active\": true }";

        // when - then
        mvc.perform(MockMvcRequestBuilders.patch("/good")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(goodDtoJson)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Товар1"))
                .andExpect(jsonPath("$.price").value(100))
                .andExpect(jsonPath("$.active").value(true));
    }

    @Test
    void getGoodById() throws Exception {
        // given
        long goodId = 1;
        GoodEntity entity = getNewEntity();
        when(goodRepository.findById(goodId)).thenReturn(Optional.of(entity));

        // when - then
        mvc.perform(get("/good/" + goodId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Товар1"))
                .andExpect(jsonPath("$.price").value(100))
                .andExpect(jsonPath("$.active").value(true));
    }

    @Test
    void getAllGoods() {
    }

    @Test
    void getGoodsByGroupId() {
    }

    public GoodEntity getNewEntity() {
        GoodEntity entity = new GoodEntity();
        entity.setId(1);
        entity.setName("Товар1");
        entity.setPrice(100);
        entity.setActive(true);
        return entity;
    }
}