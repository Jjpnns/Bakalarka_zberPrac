package com.example.bakalarka_zberprac.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LdapService {

  private final LdapTemplate ldapTemplate;
  private final String baseDn = "OU=Uniza,DC=fri,DC=sk";

  @Autowired
  public LdapService(LdapTemplate ldapTemplate) {
    this.ldapTemplate = ldapTemplate;
  }

  public boolean authenticate(String username, String password) {
    String userDn = "uid=" + username + "," + baseDn;
    try {
      ldapTemplate.authenticate(userDn, "(uid=" + username + ")", password);
      return true; // Autentifikácia úspešná
    } catch (Exception e) {
      return false; // Autentifikácia neúspešná
    }
  }

  @Override
  public Authentication authenticate(Authentication authentication) {
    String username = authentication.getName(); // Získanie používateľského mena
    String password = authentication.getCredentials().toString(); // Získanie hesla

    // Overenie platnosti používateľských údajov
    if (authenticate(username, password)) {
      UserDetails userDetails = loadUserByUsername(username);
      return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    } else {
      throw new BadCredentialsException("Neplatné prihlasovacie údaje");
    }
  }
  public List<String> findLdapUidByUsername(String uid) {

    String filter = "(uid=" + uid + ")";

    List<String> userNames = ldapTemplate.search(baseDn, filter, (AttributesMapper<String>) attrs -> {
      return attrs.get("cn").get().toString();
    });

    return userNames;
  }

  public boolean isTeacher(String username) {
    String filter = "(&(uid=" + username + ")(memberOf=CN=ucitelia,OU=Groups,DC=fri,DC=uniza,DC=sk))";
    List<String> results = ldapTemplate.search(baseDn, filter, (AttributesMapper<String>) attrs -> attrs.get("uid").get().toString());
    return !results.isEmpty();
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Načítanie používateľa z LDAP pomocou služby LdapService
    UserDetails userDetails = loadUserByUsername(username);

    // Ak sa nepodarilo načítať používateľa, vyvolajte výnimku UsernameNotFoundException
    if (userDetails == null) {
      throw new UsernameNotFoundException("Používateľ s používateľským menom " + username + " nebol nájdený.");
    }

    // Vráťte načítaného používateľa
    return userDetails;
  }


  public String getPassword(String username) {
    String filter = "(uid=" + username + ")";
    List<String> results = ldapTemplate.search(baseDn, filter, (AttributesMapper<String>) attrs -> attrs.get("userPassword").get().toString());
    if (!results.isEmpty()) {
      return results.get(0);
    } else {
      return null; // Heslo pre daného používateľa nebol nájdený
    }
  }


}



