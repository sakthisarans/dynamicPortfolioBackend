package com.portfolio.auth.model.ContentData.blog;

import lombok.Data;

@Data
public class Blog {
    private String userName;
    private String title;
    private String token;
    private BlogProviders providers;
    private String url;
}
