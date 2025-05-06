package com.portfolio.auth.model.contentresponse.blog;

import lombok.Data;

import java.util.List;

@Data
public class Blog {
    private List<Post> post;
}
