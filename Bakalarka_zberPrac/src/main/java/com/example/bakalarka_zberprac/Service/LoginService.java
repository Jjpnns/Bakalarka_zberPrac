package com.example.bakalarka_zberprac.Service;

import com.example.bakalarka_zberprac.Repository.ucitelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.bakalarka_zberprac.Service.JwtService;
import io.jsonwebtoken.Jwts;


@Service
public class LoginService {

  private final LdapTemplate ldapTemplate;

  @Autowired
  private JwtService jwtService;

  private ucitelRepository ucitelRepository;

  @Autowired
  public LoginService( LdapTemplate ldapTemplate) {
    this.ldapTemplate = ldapTemplate;
  }



  public void najdiUcitela(String uid) {
    String baseDn = "OU=People,DC=fri,DC=uniza,DC=sk";
    String filter ="(uid=" + uid + ")";
    ldapTemplate.search(baseDn, filter, (AttributesMapper<Object>) attrs -> {
      System.out.println(attrs.get("cn").get());
      return attrs.get("cn").get();
    });
  }


  public String dajRolu(String uid) {
    String baseDn ="OU=People,DC=fri,DC=uniza,DC=sk";
    String filter ="(uid=" + uid + ")";
    String[] out = new String[1];

    ldapTemplate.search(baseDn, filter, (AttributesMapper<Object>) attrs -> {
      if (attrs.get("memberOf") != null && attrs.get("memberOf").size() > 0) {
        String rola = (String) attrs.get("memberOf").get(1);
        String[] cast = rola.split(",");
        String[] CNcast = cast[0].split("=");
        String CNVal = CNcast[1];
        out[0] = CNVal;
        return CNVal;
      }
      return null;
      });
      return out[0];

  }


  public String dajMeno(String uid) {
    String baseDn = "OU=People,DC=fri,DC=uniza,DC=sk";
    String filter ="(uid=" + uid + ")";
    String[] out = new String[1];

    ldapTemplate.search(baseDn, filter, (AttributesMapper<Object>) attrs -> {
      String meno = (String) attrs.get("givenName").get();
      out[0] = meno;
      return meno;
    });
    return out[0];
  }

  public String dajPriezvisko(String uid) {
    String baseDn = "OU=People,DC=fri,DC=uniza,DC=sk";
    String filter ="(uid=" + uid + ")";
    String[] out = new String[1];

    ldapTemplate.search(baseDn, filter, (AttributesMapper<Object>) attrs -> {
      String meno = (String) attrs.get("sn").get();
      out[0] = meno;
      return meno;
    });
    return out[0];

  }

  public int dajOsobneCislo(String uid) {
    String baseDn = "OU=People,DC=fri,DC=uniza,DC=sk";
    String filter ="(uid=" + uid + ")";
    final int[] out = new int[1];

    ldapTemplate.search(baseDn, filter, (AttributesMapper<Object>) attrs -> {
      String osCislo = (String) attrs.get("uidNumber").get();

      if (osCislo != null && !osCislo.isEmpty()) {
        out[0] = Integer.parseInt(osCislo);
      }
      return null;
    });
    return out[0];
  }


  public boolean authenticate(String username, String password) {
    String baseDn = "OU=People,DC=fri,DC=uniza,DC=sk";
    String userDn = "(uid=" + username + ")";
    try {
       return ldapTemplate.authenticate(baseDn, userDn, password);
    } catch (Exception e) {
      return false; // Autentifikácia neúspešná
    }
  }


  public ResponseEntity<String> LoginLdap(@RequestParam("ldapID") String uid, @RequestParam("pass") String pass ) {
    if(authenticate(uid,pass)) {
      System.out.println("Prihlásenie bolo úspešné");
      String token = jwtService.generateToken(uid);
      return ResponseEntity.ok(token);
    } else {
      System.out.println("Prihlásenie nebolo úspešné");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Prihlásenie sa nepodarilo");
    }
  }


}

