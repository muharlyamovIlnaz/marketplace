package com.ilnaz.sellerservice.controller;


import com.ilnaz.sellerservice.dto.GoodDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/good")
@Tag(name = "GoodController")
public interface GoodApi {
    @Operation(
            summary = "Создать товар",
            description = "Создать товар",
            tags = "Good"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Товар создан",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = GoodDto.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Неверные данные",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class)
                            )
                    }
            )
    })

    @PostMapping
    GoodDto createGood(@RequestBody GoodDto goodDto);

    @DeleteMapping("/{id}")
    boolean deleteGood(@PathVariable(name = "id") long id);

    @PatchMapping
    GoodDto updateGood(@RequestBody GoodDto goodDto);

    @GetMapping("/{id}")
    GoodDto getGoodById(@PathVariable(name = "id") long id);

    @GetMapping("/seller/{id}")
    List<GoodDto> getAllGoods(@PathVariable(name = "id") long sellerId);

    @GetMapping("/group/{id}")
    List<GoodDto> getGoodsByGroupId(@PathVariable(name = "id") long goodCategoryId);

}
