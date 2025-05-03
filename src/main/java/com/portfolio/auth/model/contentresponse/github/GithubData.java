package com.portfolio.auth.model.contentresponse.github;

import lombok.Data;
import org.json.JSONObject;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GithubData {
    public GithubData(JSONObject json) {
        this.name = json.getString("name");
        this.bio = json.getString("bio");
        this.avatarUrl = json.getString("avatarUrl");
        this.location = json.getString("location");
        this.pinnedItems=new PinnedItems(json.getJSONObject("pinnedItems"));
    }
    private String name;
    private String bio;
    private String avatarUrl;
    private String location;
    private PinnedItems pinnedItems;
}
