package com.portfolio.auth.model.token;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data@Builder
@Document(collection = "userToken")
public class Token {
    @Id
    private String id;
    private String baseDomain;
    private String userEmail;
    private String token;
    private Date dateOfCreation;
    private String userCollectionId;
    private String tokenType;
    private boolean isActive;
    private Date dateOfDeactivation;
}
