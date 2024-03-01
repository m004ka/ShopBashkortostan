package org.urr.shopbashkortostan.TokenJWT;


import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.urr.shopbashkortostan.service.Impl.UserDetailsImpl;


import java.util.Date;

@Component
public class JwtCore {
    @Value("${shopbashkortostan.app.secret}")
    private String secret;
    @Value("${testing.app.expirationMs}")
    private int lifetime;

    public String generateToken(Authentication authentication) {

        Date now = new Date();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Date expiryDate = new Date(now.getTime() + lifetime * 1000L);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getNameFromJwt(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return (claims.getSubject());
    }




}
