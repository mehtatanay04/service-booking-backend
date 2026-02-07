package com.tanay.bookingapp.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 1 day
private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

public static String generateToken(Long userId, String email, String role) {

return Jwts.builder()
.setSubject(email)
.claim("id", userId)
.claim("role", role)
.setIssuedAt(new Date())
.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
.signWith(key)
.compact();
}
public static Claims validateToken(String token) {

try {
Jws<Claims> claimsJws = Jwts.parserBuilder()
.setSigningKey(key)
.build()
.parseClaimsJws(token);

return claimsJws.getBody();

} catch (JwtException e) {
return null;
}
}

}
