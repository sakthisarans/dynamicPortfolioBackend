package com.portfolio.auth.repository;

import com.portfolio.auth.model.ContentData.Content;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContentRepository extends MongoRepository<Content, String> {
    public Content findByDomain(String domain);
}
