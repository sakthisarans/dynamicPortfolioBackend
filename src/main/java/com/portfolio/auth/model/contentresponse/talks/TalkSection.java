package com.portfolio.auth.model.contentresponse.talks;

import lombok.Data;

import java.util.List;

@Data
public class TalkSection {
    private String title;
    private String subtitle;
    private List<Talk> talks;
    private boolean display;
}
