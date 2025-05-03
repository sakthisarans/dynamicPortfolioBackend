package com.portfolio.auth.model.contentresponse.github;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PinnedItems {
        public PinnedItems(JSONObject json) {
                this.totalCount = json.getInt("totalCount");
                JSONArray items = json.getJSONArray("edges");
                this.edges = new ArrayList<>();
                for (int i = 0; i < items.length(); i++) {
                        this.edges.add(new Edge(items.getJSONObject(i)));
                }
        }
        private int totalCount;
        private List<Edge> edges;
}
