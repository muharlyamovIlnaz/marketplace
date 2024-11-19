package com.ilnaz.userservice.service;

import com.ilnaz.userservice.enums.Role;
import com.ilnaz.userservice.exception.UserAlreadyExistsException;
import com.ilnaz.userservice.logging.Logging;
import com.ilnaz.userservice.models.User;
import com.ilnaz.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    @Logging
    public User save(User user) {
        return repository.save(user);
    }

    @Logging
    public User create(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            log.error("Пользователь с таким именем уже существует");
            throw new UserAlreadyExistsException("Пользователь с таким именем уже существует");
        }
        return save(user);
    }

    @Logging
    public User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Пользователь не найден"));
    }

    @Logging
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    @Logging
    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

    @Logging
    @Deprecated
    public void getAdmin() {
        User user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        save(user);
    }
}