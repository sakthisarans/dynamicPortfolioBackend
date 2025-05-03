package com.portfolio.auth.model.contentresponse;

import lombok.Data;

@Data
public class SocialMediaLinks {
    private String github;
    private String linkedin;
    private String gmail;
    private boolean enabled;
}
