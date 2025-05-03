package com.portfolio.auth.model.contentresponse.github;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Edge {
    public Edge(JSONObject obj) {
        this.node=new GitHub(obj.getJSONObject("node"));
    }
    private GitHub node;

}
