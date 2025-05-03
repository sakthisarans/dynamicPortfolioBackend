package com.portfolio.auth.model.contentresponse.blog;

import lombok.Data;

import java.util.List;

@Data
public class CustomBlogData {
    private String title;
    private String subtitle;
    private boolean displayMediumBlogs;
    private List<CustomBlog> blogs;
    private boolean display;
}
