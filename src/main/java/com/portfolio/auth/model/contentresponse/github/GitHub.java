package com.portfolio.auth.model.contentresponse.github;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GitHub {
    public GitHub(JSONObject json) {
        this.id = json.getString("id");
        this.name = json.getString("name");
        this.description = json.optString("description","");
        this.forkCount = json.getInt("forkCount");
        this.url = json.getString("url");
        this.diskUsage=json.getInt("diskUsage");
        this.stargazers=new Stargazers(json.getJSONObject("stargazers"));
        this.primaryLanguage=new PrimaryLanguage(json.getJSONObject("primaryLanguage"));
    }
    private String name;
    private String description;
    private int forkCount;
    private Stargazers stargazers;
    private String url;
    private String id;
    private int diskUsage;
    private PrimaryLanguage primaryLanguage;
}
