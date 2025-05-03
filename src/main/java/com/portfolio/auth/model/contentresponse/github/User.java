package com.portfolio.auth.model.contentresponse.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
@Data@AllArgsConstructor@NoArgsConstructor
public class User {
    public User(JSONObject json) {
        log.debug("User: {}", json);
        this.user=new GithubData(json.getJSONObject("user"));
    }
    private GithubData user;
}
