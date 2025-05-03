package com.portfolio.auth.model.ContentData.education;

import lombok.Data;

import java.util.List;

@Data
public class EducationSection {
    private boolean display;
    private List<School> schools;
}
