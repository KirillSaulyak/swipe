package com.project.swipe.config.jwt;

import com.project.swipe.config.userDetails.CustomUserDetails;
import com.project.swipe.config.userDetails.CustomUserDetailsService;
import com.project.swipe.model.JwtSecrets;
import com.project.swipe.service.service.JwtSecretsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class JwtFilter extends GenericFilterBean {
    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtSecretsService jwtSecretsService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        try {
            String token = getTokenFromRequest((HttpServletRequest) servletRequest);
            if (token != null) {
                String secret = jwtSecretsService.findFirst().getJwtSecret();
                if (jwtProvider.validateToken(token, secret)) {
                    String userLogin = jwtProvider.getLoginFormToken(token, secret);
                    CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userLogin);
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            customUserDetails, null, customUserDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (IOException exception) {
            System.out.println(exception.toString());
        } catch (ServletException exception) {
            System.out.println(exception.toString());
        }
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        if (bearer != null && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }
}

