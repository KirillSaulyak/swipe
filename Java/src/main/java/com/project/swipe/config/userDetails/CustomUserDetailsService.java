package com.project.swipe.config.userDetails;

import com.project.swipe.model.Authorizations;
import com.project.swipe.service.service.AuthorizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthorizationsService authorizationsService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        try {
            Authorizations authorizations = authorizationsService.findByLogin(username);
            if (authorizations == null) {
                throw new UsernameNotFoundException("Not such user name");
            }
            return CustomUserDetails.fromAuthorizationToCustomUserDetails(authorizations);
        } catch (UsernameNotFoundException exception) {
            exception.fillInStackTrace();
            return null;
        }
    }
}
