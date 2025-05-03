package com.portfolio.auth.model.ContentData;

import lombok.Data;

@Data
public class GreetingsData {
    private String username;
    private String title;
    private String subTitle;
    private String resumeLink;
    private boolean enabled;
}
