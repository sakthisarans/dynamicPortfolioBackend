package com.portfolio.auth.model.contentresponse;

import lombok.Data;

@Data
public class Greetings {
    private String username;
    private String title;
    private String subTitle;
    private String resumeLink;
    private boolean enabled;
}
