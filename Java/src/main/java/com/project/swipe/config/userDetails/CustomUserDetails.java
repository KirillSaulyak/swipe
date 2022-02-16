package com.project.swipe.config.userDetails;


import com.project.swipe.model.Authorizations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private String login;
    private String password;
    private boolean isAccountNonLocked;
    private GrantedAuthority grantedAuthorities;


    public static CustomUserDetails fromAuthorizationToCustomUserDetails(Authorizations authorizations) {
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.login = authorizations.getLogin();
        customUserDetails.password = authorizations.getPassword();
        customUserDetails.isAccountNonLocked = authorizations.isEnabled();
        customUserDetails.grantedAuthorities = new SimpleGrantedAuthority(authorizations.getPersonalAccountsByIdAuthorization().getAccountTypesByIdAccountType().getName());
        return customUserDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(grantedAuthorities);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
