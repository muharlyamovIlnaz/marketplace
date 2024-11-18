package com.ilnaz.userservice.controller;

import com.ilnaz.userservice.dto.JwtAuthenticationResponse;
import com.ilnaz.userservice.dto.SignInRequest;
import com.ilnaz.userservice.dto.SignUpRequest;
import com.ilnaz.userservice.service.AuthenticationService;
import com.ilnaz.userservice.service.JwtService;
import com.ilnaz.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final UserService userService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public String signUp(@RequestBody @Valid SignUpRequest request) {
        return authenticationService.signUp(request);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }

    @Operation(summary = "Проверка валидности токена")
    @PostMapping("/validate")
    public ResponseEntity<Map<String, String>> validateToken(@RequestHeader("Authorization") String token) {
        String jwt = token.replace("Bearer ", "");
        if (jwtService.isTokenValid(jwt)) {
            String role = jwtService.extractRole(jwt);
            return ResponseEntity.ok(Map.of("role", role));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
