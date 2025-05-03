package com.portfolio.auth.model.contentresponse.blog;

import lombok.Data;

@Data
public class Post {
    private String id;
    private String uuid;
    private String title;
    private String slug;
    private String html;
    private String comment_id;
    private String feature_image;
    private boolean featured;
    private String visibility;
    private String created_at;
    private String updated_at;
    private String published_at;
    private String custom_excerpt;
    private String codeinjection_head;
    private String codeinjection_foot;
    private String custom_template;
    private String canonical_url;
    private String url;
    private String excerpt;
    private int reading_time;
    private boolean access;
    private boolean comments;
    private String og_image;
    private String og_title;
    private String og_description;
    private String twitter_image;
    private String twitter_title;
    private String twitter_description;
    private String meta_title;
    private String meta_description;
    private String email_subject;
    private String frontmatter;
    private String feature_image_alt;
    private String feature_image_caption;

    // Getters and Setters
}

