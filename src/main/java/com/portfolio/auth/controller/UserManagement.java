package com.portfolio.auth.controller;


import com.portfolio.auth.model.user.SignInRequest;
import com.portfolio.auth.model.user.SignUpRequest;
import com.portfolio.auth.repository.ContentRepository;
import com.portfolio.auth.repository.UserDetailsRepository;
import com.portfolio.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth/user")
public class UserManagement {

    @Autowired
    private AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest user) {
        return authService.signUp(user);
    }

    @GetMapping("/validateDomain")
    public ResponseEntity<?> validateDomain(@RequestParam("domain") String domain) {
        return authService.validateDomain(domain);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInRequest user) {
        return authService.login(user);
    }
}
