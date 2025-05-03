package com.portfolio.auth.repository;

import com.portfolio.auth.model.token.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenValidationRepository extends MongoRepository<Token,String> {
// @Query("{'': ?0}")
 public Token findByToken(String token);
 public Token findByUserEmail(String userEmail);
}
