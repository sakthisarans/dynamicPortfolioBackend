package com.portfolio.auth.model.ContentData.workexperience;

import lombok.Data;

import java.util.List;

@Data
public class WorkExperiences {
    private boolean display;
    private List<WorkExperience> experience;
}
