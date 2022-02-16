package com.project.swipe.config.jwt;

import io.jsonwebtoken.*;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Configuration
public class JwtProvider {
    private String jwtBuilder(String login, String secret, Date date) {
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String generateToken(String login, String secret) {
        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).plusMinutes(1).toInstant());
        return jwtBuilder(login, secret, date);
    }

    public String generateRefreshToken(String login, String secret) {
        Date date = Date.from(LocalDate.now().plusDays(60).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return jwtBuilder(login, secret, date);
    }

    public boolean validateToken(String token, String secret) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException exception) {
            System.out.println(exception.getMessage());
        } catch (UnsupportedJwtException exception) {
            System.out.println(exception.getMessage());
        } catch (MalformedJwtException exception) {
            System.out.println(exception.getMessage());
        } catch (SignatureException exception) {
            System.out.println(exception.getMessage());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    public String getLoginFormToken(String token, String secret) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
}
