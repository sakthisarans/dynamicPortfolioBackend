package com.portfolio.auth.model.user;

import lombok.Data;

@Data
public class SignInRequest {
    private String email;
    private String password;
}
