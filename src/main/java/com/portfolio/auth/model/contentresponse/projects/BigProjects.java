package com.portfolio.auth.model.contentresponse.projects;

import lombok.Data;

import java.util.List;

@Data
public class BigProjects {
    private String title;
    private String subtitle;
    private List<Project> projects;
    private boolean display;
}
