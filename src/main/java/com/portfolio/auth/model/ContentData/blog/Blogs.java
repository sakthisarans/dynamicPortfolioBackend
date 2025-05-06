package com.portfolio.auth.model.ContentData.blog;

import java.util.List;

import lombok.Data;

@Data
public class Blogs {

    private BlogProviders providers;
    private List<Blog> blogs;
}
