package com.example.bakalarka_zberprac.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class JwtService {

  private String secret = "secret123";
  private long expiration = 36000;

  private List<String> blackListedTokens = new ArrayList<>();

  public String generateToken(String uid) {
    Date now = new Date();
    Date expire = new Date(now.getTime() + expiration);

    return Jwts.builder()
      .setSubject(uid)
      .setIssuedAt(now)
      .setExpiration(expire)
      .signWith(SignatureAlgorithm.HS256, secret)
      .compact();
  }


  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public String getUserFromToken(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean ivalidateToken(String token) {
    if (validateToken(token)) {
      blackListedTokens.add(token);
      return true;
    }
    return false;
  }

}
