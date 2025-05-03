package com.portfolio.auth.model.ContentData.skills;

import lombok.Data;

import java.util.List;

@Data
public class WhatIDo {
    private String title;
    private String subTitle;
    private List<String> skills;
    private List<SoftwareSkill> softwareSkills;
    private boolean display;
}
