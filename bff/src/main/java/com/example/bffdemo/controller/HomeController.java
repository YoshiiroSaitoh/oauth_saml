package com.example.bffdemo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home(
            @AuthenticationPrincipal OidcUser user
    ) {

        if (user == null) {
            return Map.of(
                    "message", "not logged in"
            );
        }

        return Map.of(
                "name", user.getFullName(),
                "email", user.getEmail(),
                "claims", user.getClaims()
        );
    }
}