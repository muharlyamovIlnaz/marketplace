package com.ilnaz.userservice.repository;


import com.ilnaz.userservice.logging.Logging;
import com.ilnaz.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Logging
    boolean existsByUsername(String username);

    @Logging
    Optional<User> findByUsername(String username);
}
