package com.portfolio.auth.config;

import com.portfolio.auth.model.user.SignUpRequest;
import com.portfolio.auth.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SignUpRequest user = userDetailsRepository.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found with username: " + email);
        }
        return UserDetailsImpl.build(user);
    }
}
