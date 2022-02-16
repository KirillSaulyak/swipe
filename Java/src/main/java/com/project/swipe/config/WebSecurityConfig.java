package com.project.swipe.config;

import com.project.swipe.config.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/registration", "/check-login", "/check-jwt-refresh-token", "/check-password", "/swagger-ui/**", "/v3/**").permitAll()
                .antMatchers("/account-type-admins/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers("/account-type-developers/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER_DEVELOPER.toString())
                .antMatchers("/account-type-private-persons/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER_PRIVATE_PERSON.toString())
                .antMatchers(HttpMethod.GET, "/account-types/**").authenticated()
                .antMatchers("/account-types/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/agents/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER_PRIVATE_PERSON.toString())
                .antMatchers("/agents/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.POST, "/apartment-ads/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER_PRIVATE_PERSON.toString())
                .antMatchers("/apartment-ads/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/apartments/**").authenticated()
                .antMatchers("/apartments/**").hasAnyAuthority(Role.USER_DEVELOPER.toString(), Role.USER_PRIVATE_PERSON.toString())
                .antMatchers(HttpMethod.GET, "/apartments-buildings/**").authenticated()
                .antMatchers("/apartments-buildings/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/apartments-description/**").authenticated()
                .antMatchers("/apartments-description/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER_DEVELOPER.toString())
                .antMatchers(HttpMethod.GET, "/apartments-description-agent-commissions/**").authenticated()
                .antMatchers("/apartments-description-agent-commissions/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/apartments-description-appointments/**").authenticated()
                .antMatchers("/apartments-description-appointments/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/apartments-description-balconies/**").authenticated()
                .antMatchers("/apartments-description-balconies/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/apartments-description-calculation-options/**").authenticated()
                .antMatchers("/apartments-description-calculation-options/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/apartments-description-foundation-documents/**").authenticated()
                .antMatchers("/apartments-description-foundation-documents/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/apartments-description-layouts/**").authenticated()
                .antMatchers("/apartments-description-layouts/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/apartments-description-living-conditions/**").authenticated()
                .antMatchers("/apartments-description-living-conditions/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/apartments-description-number-of-rooms/**").authenticated()
                .antMatchers("/apartments-description-number-of-rooms/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/apartments-description-ways-of-communication/**").authenticated()
                .antMatchers("/apartments-description-ways-of-communication/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/apartments-galleries/**").authenticated()
                .antMatchers("/apartments-galleries/**").hasAnyAuthority(Role.USER_DEVELOPER.toString(), Role.USER_PRIVATE_PERSON.toString())
                .antMatchers(HttpMethod.GET, "/authorizations/**").authenticated()
                .antMatchers("/authorizations/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers("/personal-accounts/**").authenticated()
                .antMatchers(HttpMethod.GET, "/real-estate-types/**").authenticated()
                .antMatchers("/real-estate-types/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.POST, "/residential-complex-ads/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER_DEVELOPER.toString())
                .antMatchers("/residential-complex-ads/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes/**").authenticated()
                .antMatchers("/residential-complexes/**").hasAnyAuthority(Role.ADMIN.toString(), Role.USER_DEVELOPER.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-area-types/**").authenticated()
                .antMatchers("/residential-complexes-area-types/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-classes/**").authenticated()
                .antMatchers("/residential-complexes-classes/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-communal-payments/**").authenticated()
                .antMatchers("/residential-complexes-communal-payments/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-construction-technologies/**").authenticated()
                .antMatchers("/residential-complexes-construction-technologies/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-descriptions/**").authenticated()
                .antMatchers("/residential-complexes-descriptions/**").hasAnyAuthority(Role.USER_DEVELOPER.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-files/**").authenticated()
                .antMatchers("/residential-complexes-files/**").hasAnyAuthority(Role.USER_DEVELOPER.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-galleries/**").authenticated()
                .antMatchers("/residential-complexes-galleries/**").hasAnyAuthority(Role.USER_DEVELOPER.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-gas-types/**").authenticated()
                .antMatchers("/residential-complexes-gas-types/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-heating-types/**").authenticated()
                .antMatchers("/residential-complexes-heating-types/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-news/**").authenticated()
                .antMatchers("/residential-complexes-news/**").hasAnyAuthority(Role.USER_DEVELOPER.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-sales-departments/**").authenticated()
                .antMatchers("/residential-complexes-sales-departments/**").hasAnyAuthority(Role.USER_DEVELOPER.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-sewerage-types/**").authenticated()
                .antMatchers("/residential-complexes-sewerage-types/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-statuses/**").authenticated()
                .antMatchers("/residential-complexes-statuses/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-types-houses/**").authenticated()
                .antMatchers("/residential-complexes-types-houses/**").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/residential-complexes-water-supply-types/**").authenticated()
                .antMatchers("/residential-complexes-water-supply-types/**").hasAnyAuthority(Role.ADMIN.toString())
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
