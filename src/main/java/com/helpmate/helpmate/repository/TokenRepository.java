package com.helpmate.helpmate.repository;

import com.helpmate.helpmate.entity.AuthenticationToken;
import com.helpmate.helpmate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findByUser(User user);
    AuthenticationToken findByToken(String token);

}
