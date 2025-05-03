package com.portfolio.auth.model.contentresponse.education;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private String schoolName;
    private String logo; // In Java, we’ll store logo paths as Strings
    private String subHeader;
    private String duration;
    private String desc;
    private List<String> descBullets;
}
