package com.portfolio.auth.model.ContentData.projects;

import lombok.Data;

import java.util.List;

@Data
public class Project {
    private String image; // Use String to represent the image path
    private String projectName;
    private String projectDesc;
    private List<FooterLink> footerLink;
}
