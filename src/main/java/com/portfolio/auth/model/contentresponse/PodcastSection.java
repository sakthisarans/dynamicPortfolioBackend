package com.portfolio.auth.model.contentresponse;

import lombok.Data;

import java.util.List;

@Data
public class PodcastSection {
    private String title;
    private String subtitle;
    private List<String> podcast;
    private boolean display;
}
