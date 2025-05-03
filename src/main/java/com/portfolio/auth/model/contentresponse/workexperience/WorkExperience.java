package com.portfolio.auth.model.contentresponse.workexperience;

import lombok.Data;

import java.util.List;

@Data
public class WorkExperience {
    private String role;
    private String company;
    private String companylogo; // Representing the image path as a String
    private String date;
    private String desc;
    private List<String> descBullets;
}
