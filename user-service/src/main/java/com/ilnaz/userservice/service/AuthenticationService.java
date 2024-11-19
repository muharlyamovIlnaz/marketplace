package com.ilnaz.userservice.service;

import com.ilnaz.userservice.dto.JwtAuthenticationResponse;
import com.ilnaz.userservice.dto.SignInRequest;
import com.ilnaz.userservice.dto.SignUpRequest;
import com.ilnaz.userservice.enums.Role;
import com.ilnaz.userservice.logging.Logging;
import com.ilnaz.userservice.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Logging
    public String signUp(SignUpRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf(request.getRole().toUpperCase()))
                .build();

        userService.create(user);
        return "signUp success";
    }

    @Logging
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        UserDetails user = userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());

        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    @Logging
    public ResponseEntity<Role> validateTokenAndGetRole(String token) {
        return ResponseEntity.ok(Role.valueOf(jwtService.extractRole(token)));
    }
}