package com.portfolio.auth.controller;

import com.portfolio.auth.config.UserDetailsImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController

@RequestMapping("/auth/token")
public class ValidateToken {
    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader(name = "Authorization", required = true) String authToken) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
        Map<String,String> response=new HashMap<>();
        response.put("username",user.getUsername());
        response.put("email",user.getEmail());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
