package com.portfolio.auth.model.contentresponse.achievements;

import lombok.Data;

import java.util.List;

@Data
public class AchievementCard {
    private String title;
    private String subtitle;
    private String image;      // Use String for image path/URL
    private String imageAlt;
    private List<FooterLink> footerLink;
}
