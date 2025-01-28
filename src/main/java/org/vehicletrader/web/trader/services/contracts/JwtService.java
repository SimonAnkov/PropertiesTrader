package org.vehicletrader.web.trader.services.contracts;

import java.util.Date;

import io.jsonwebtoken.Claims;

import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    Boolean validateToken(String token, UserDetails userDetails);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    Date extractExpiration(String token);

    String extractUsername(String token);

    String generateToken(String userName);
}
