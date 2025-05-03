package com.portfolio.auth.model.ContentData;

import com.portfolio.auth.model.ContentData.achievements.AchievementSection;
import com.portfolio.auth.model.ContentData.blog.Blog;
import com.portfolio.auth.model.ContentData.education.EducationSection;
import com.portfolio.auth.model.ContentData.projects.BigProjects;
import com.portfolio.auth.model.ContentData.skills.WhatIDo;
import com.portfolio.auth.model.ContentData.talks.TalkSection;
import com.portfolio.auth.model.ContentData.teckstack.ProficiencySection;
import com.portfolio.auth.model.ContentData.workexperience.WorkExperiences;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "content")
public class Content {
    @Id
    private String id;
    private String domain;
    private GreetingsData greetings;
    private SocialMediaLinksData socialMediaLinks;
    private Resume resume;
    private Github github;
    private WhatIDo skillSet;
    private ProficiencySection teckStack;
    private EducationSection educationSection;
    private WorkExperiences workExperiences;
    private BigProjects projects;
    private AchievementSection achievement;
    private TalkSection talks;
    private boolean hireable;
    private ContactMe contactMe;
    private Twitter twitter;
    private PodcastSection podcast;
    private Blog blog;
    private OpenSource openSource;
}
