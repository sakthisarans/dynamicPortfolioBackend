package com.portfolio.auth.model.ContentData.achievements;

import lombok.Data;

import java.util.List;

@Data
public class AchievementSection {
    private String title;
    private String subtitle;
    private List<AchievementCard> achievementsCards;
    private boolean display;

}
