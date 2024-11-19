package com.ilnaz.gateway.controller.impl;

import com.ilnaz.gateway.dto.UserJwtAuthenticationResponse;
import com.ilnaz.gateway.dto.UserSignInRequest;
import com.ilnaz.gateway.dto.UserSignUpRequest;
import com.ilnaz.gateway.logging.Logging;
import com.ilnaz.gateway.service.UserAuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class UserAuthController {

    private final UserAuthenticationService userAuthenticationService;

    @Logging
    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public String signUp(@RequestBody @Valid UserSignUpRequest request) {
        return userAuthenticationService.signUp(request);
    }

    @Logging
    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public UserJwtAuthenticationResponse signIn(@RequestBody @Valid UserSignInRequest request) {
        return userAuthenticationService.signIn(request);
    }
}
