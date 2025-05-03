package com.portfolio.auth.repository;

import com.portfolio.auth.model.user.SignUpRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends MongoRepository<SignUpRequest,String> {
    public SignUpRequest findByEmail(String email);
    public SignUpRequest findByBasePath(String basePath);
}
