package com.portfolio.auth.model.contentresponse.github;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PrimaryLanguage {
    public PrimaryLanguage(JSONObject json) {
        this.color = json.getString("color");
        this.name = json.getString("name");
    }
    private String name;
    private String color;
}
