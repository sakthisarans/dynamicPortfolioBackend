package com.portfolio.auth.service;

import com.portfolio.auth.config.JwtUtils;
import com.portfolio.auth.config.UserDetailsImpl;
import com.portfolio.auth.model.ContentData.Content;
import com.portfolio.auth.model.token.Token;
import com.portfolio.auth.model.user.SignInRequest;
import com.portfolio.auth.model.user.SignUpRequest;
import com.portfolio.auth.repository.ContentRepository;
import com.portfolio.auth.repository.TokenValidationRepository;
import com.portfolio.auth.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthService {
    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    TokenValidationRepository tokenValidationRepository;
    @Value("${jwt.token.jwtExpirationMs}")
    private long jwtExpirationMs;
    @Value("${portfolio.domain}")
    private String domain;

    @Autowired
    private ContentRepository contentRepository;


    public ResponseEntity<?> signUp(SignUpRequest user) {
        if(userDetailsRepository.findByEmail(user.getEmail())==null){
            user.setPassword(encoder.encode(user.getPassword()));
            user.setDateOfCreation(new Date());
            userDetailsRepository.save(user);
            Content content=new Content();
            content.setDomain(user.getBasePath()+"."+domain);
            contentRepository.save(content);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Sign up successful");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            Map<String,String> response = new HashMap<>();
            response.put("message","Email already exists");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<?> validateDomain(String domain) {
        if(userDetailsRepository.findByBasePath(domain)==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    public ResponseEntity<?> login(SignInRequest signinRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication,jwtExpirationMs);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Token tokenInfo=Token.builder().token(jwt).
                userCollectionId(userDetails.getId()).
                userEmail(userDetails.getEmail()).
                dateOfCreation(new Date()).
                isActive(true).tokenType("JWT")
                .build();
        tokenValidationRepository.save(tokenInfo);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("token", jwt);
        response.put("type", "Bearer");
        response.put("userName", userDetails.getUsername());
        response.put("email", userDetails.getEmail());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
