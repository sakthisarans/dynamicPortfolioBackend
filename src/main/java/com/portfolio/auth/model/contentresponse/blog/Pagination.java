package com.portfolio.auth.model.contentresponse.blog;

import lombok.Data;

@Data
public class Pagination {
    private int page;
    private int limit;
    private int pages;
    private int total;
    private Object next; // Can be Integer or null, so use Object
    private Object prev;
}
