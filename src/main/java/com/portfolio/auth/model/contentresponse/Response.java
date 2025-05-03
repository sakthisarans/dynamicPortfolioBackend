package com.portfolio.auth.model.contentresponse;

import com.portfolio.auth.model.contentresponse.achievements.AchievementSection;
import com.portfolio.auth.model.contentresponse.blog.Blog;
import com.portfolio.auth.model.contentresponse.education.EducationSection;
import com.portfolio.auth.model.contentresponse.github.User;
import com.portfolio.auth.model.contentresponse.projects.BigProjects;
import com.portfolio.auth.model.contentresponse.skills.WhatIDo;
import com.portfolio.auth.model.contentresponse.talks.TalkSection;
import com.portfolio.auth.model.contentresponse.teckstack.ProficiencySection;
import com.portfolio.auth.model.contentresponse.workexperience.WorkExperiences;
import lombok.Data;

@Data
public class Response {
    private Greetings greetings;
    private SocialMediaLinks socialMediaLinks;
    private User gitHub;
    private Blog blog;
    private WhatIDo skillsSection;
    private ProficiencySection teckStackSection;
    private EducationSection educationSection;
    private WorkExperiences workExperiences;
    private BigProjects projects;
    private AchievementSection achievementSection;
    private TalkSection talkSection;
    private boolean isHireable;
    private PodcastSection podcastSection;
    private ContactMe contactMe;
    private Twitter twitter;
    private Resume resume;
    private OpenSource openSource;


}
