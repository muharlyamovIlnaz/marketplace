package com.ilnaz.gateway.service;

import com.ilnaz.gateway.config.ClientConfiguration;
import com.ilnaz.gateway.dto.GoodDto;
import com.ilnaz.gateway.dto.SellerServiceResponse;
import com.ilnaz.gateway.logging.Logging;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final ClientConfiguration clientConfiguration;

    @Value("${path.seller-service}")
    private String basePath;

    @Logging
    public SellerServiceResponse<GoodDto> createGood(GoodDto goodDto) {
        RestTemplate restTemplate = clientConfiguration.getRestTemplate();
        String url = basePath + "/good";
        HttpEntity<GoodDto> requestEntity = new HttpEntity<>(goodDto);
        ResponseEntity<SellerServiceResponse<GoodDto>> response =
                restTemplate.exchange(url,
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<SellerServiceResponse<GoodDto>>() {
                        }
                );
        return response.getBody();
    }

    @Logging
    public SellerServiceResponse<GoodDto> updateGood(GoodDto goodDto) {
        RestTemplate restTemplate = clientConfiguration.getRestTemplate();
        String url = basePath + "/good";
        HttpEntity<GoodDto> requestEntity = new HttpEntity<>(goodDto);
        ResponseEntity<SellerServiceResponse<GoodDto>> response =
                restTemplate.exchange(url,
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<SellerServiceResponse<GoodDto>>() {
                        }
                );
        return response.getBody();
    }

    @Logging
    public SellerServiceResponse<Void> deleteGood(long id) {
        RestTemplate restTemplate = clientConfiguration.getRestTemplate();
        String url = basePath + "/good/" + id;
        ResponseEntity<SellerServiceResponse<Void>> response =
                restTemplate.exchange(url,
                        HttpMethod.DELETE,
                        HttpEntity.EMPTY,
                        new ParameterizedTypeReference<SellerServiceResponse<Void>>() {
                        }
                );
        return response.getBody();
    }

    @Logging
    public SellerServiceResponse<GoodDto> getGoodById(long id) {
        RestTemplate restTemplate = clientConfiguration.getRestTemplate();
        String url = basePath + "/good/" + id;
        ResponseEntity<SellerServiceResponse<GoodDto>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        new ParameterizedTypeReference<SellerServiceResponse<GoodDto>>() {
                        }
                );
        return response.getBody();
    }

    @Logging
    public SellerServiceResponse<List<GoodDto>> getAllGoods(long sellerId) {
        RestTemplate restTemplate = clientConfiguration.getRestTemplate();
        String url = basePath + "/good/seller/" + sellerId;
        ResponseEntity<SellerServiceResponse<List<GoodDto>>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        new ParameterizedTypeReference<SellerServiceResponse<List<GoodDto>>>() {
                        }
                );
        return response.getBody();
    }

    @Logging
    public SellerServiceResponse<List<GoodDto>> getGoodsByGroupId(long goodCategoryId) {
        RestTemplate restTemplate = clientConfiguration.getRestTemplate();
        String url = basePath + "/good/group/" + goodCategoryId;
        ResponseEntity<SellerServiceResponse<List<GoodDto>>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        new ParameterizedTypeReference<SellerServiceResponse<List<GoodDto>>>() {
                        }
                );
        return response.getBody();
    }


}

