package br.edu.ufersa.blockbuster.domain.service;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationService {
  static final long EXPIRATIONTIME = 864_000_00;
  static final String SIGNINGKEY = "SecretKey";
  static final String PREFIX = "Bearer";

  static public void addToken(HttpServletResponse res, String email) {
    String jwtToken = Jwts.builder().setSubject(email)
      .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
      .signWith(SignatureAlgorithm.HS512, SIGNINGKEY)
      .compact();

    res.addHeader("Authorization", PREFIX + " " + jwtToken);
    res.addHeader("Access-Control-Expose-Headers", "Authorization");
  }
}
