package com.portfolio.auth.model.contentresponse.github;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Stargazers {
    public Stargazers(JSONObject node) {
        this.totalCount=node.getInt("totalCount");
    }
    private int totalCount;
}
