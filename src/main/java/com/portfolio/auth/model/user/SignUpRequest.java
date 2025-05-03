package com.portfolio.auth.model.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "userData")
public class SignUpRequest {
    @Id
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String basePath;
    private Date dateOfCreation;
}
