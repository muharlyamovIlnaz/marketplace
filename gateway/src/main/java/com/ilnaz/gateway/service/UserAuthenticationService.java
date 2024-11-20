package com.ilnaz.gateway.service;

import com.ilnaz.gateway.config.ClientConfiguration;
import com.ilnaz.gateway.dto.UserJwtAuthenticationResponse;
import com.ilnaz.gateway.dto.UserSignInRequest;
import com.ilnaz.gateway.dto.UserSignUpRequest;
import com.ilnaz.gateway.logging.Logging;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserAuthenticationService {
    private final ClientConfiguration clientConfiguration;

    @Value("${path.user-service}")
    private String basePath;

    @Logging
    public String signUp(UserSignUpRequest request) {
        RestTemplate restTemplate = clientConfiguration.getRestTemplate();
        String url = basePath + "/auth/sign-up";
        HttpEntity<UserSignUpRequest> requestEntity = new HttpEntity<>(request);
        ResponseEntity<String> response =
                restTemplate.exchange(url,
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<String>() {
                        }
                );
        return response.getBody();

    }

    @Logging
    public UserJwtAuthenticationResponse signIn(UserSignInRequest request) {
        RestTemplate restTemplate = clientConfiguration.getRestTemplate();
        String url = basePath + "/auth/sign-in";
        HttpEntity<UserSignInRequest> requestEntity = new HttpEntity<>(request);
        ResponseEntity<UserJwtAuthenticationResponse> response =
                restTemplate.exchange(url,
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<UserJwtAuthenticationResponse>() {
                        }
                );
        return response.getBody();
    }
}