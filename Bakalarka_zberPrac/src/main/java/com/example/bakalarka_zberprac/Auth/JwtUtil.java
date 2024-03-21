package com.example.bakalarka_zberprac.Auth;

import com.example.bakalarka_zberprac.Core.User;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

  private final String secret_key = "mysecretkey";
  private final long accessTokenValidity = 60 * 60 * 1000; // 1 hour

  public String createToken(User user) {
    Claims claims = Jwts.claims().setSubject(user.getLogin());
    claims.put("firstName", user.getFirstName());
    claims.put("lastName", user.getLastName());
    Date tokenValidity = new Date(System.currentTimeMillis() + accessTokenValidity);
    return Jwts.builder()
      .setClaims(claims)
      .setExpiration(tokenValidity)
      .signWith(SignatureAlgorithm.HS256, secret_key)
      .compact();
  }

  public Claims parseJwtClaims(String token) {
    return Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token).getBody();
  }

  public Claims resolveClaims(HttpServletRequest req) {
    String token = resolveToken(req);
    if (token != null) {
      return parseJwtClaims(token);
    }
    return null;
  }

  public String resolveToken(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");
    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }
    return null;
  }

  public boolean validateClaims(Claims claims) {
    return claims.getExpiration().after(new Date());
  }

  public String getEmail(Claims claims) {
    return claims.getSubject();
  }

  public List<String> getRoles(Claims claims) {
    return (List<String>) claims.get("roles");
  }

  public String extractUsername(String token) {
    Claims claims = parseJwtClaims(token);
    return claims.getSubject();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public Authentication getAuthentication(String token) {
    Claims claims = parseJwtClaims(token);
    String username = claims.getSubject();
    List<String> authorities = (List<String>) claims.get("authorities");
    List<SimpleGrantedAuthority> grantedAuthorities = authorities.stream()
      .map(SimpleGrantedAuthority::new)
      .collect(Collectors.toList());
    String firstName = claims.get("firstName", String.class);
    String lastName = claims.get("lastName", String.class);
    UserDetails userDetails = new User(username, ""); // Vytvorte triedu UserDetailService a použite ju na načítanie informácií o používateľovi
    return new UsernamePasswordAuthenticationToken(userDetails, "", grantedAuthorities);
  }
}
