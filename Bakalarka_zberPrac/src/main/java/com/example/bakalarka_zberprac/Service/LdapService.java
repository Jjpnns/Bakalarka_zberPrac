package com.example.bakalarka_zberprac.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LdapService {

  private final LdapTemplate ldapTemplate;

  @Autowired
  public LdapService(LdapTemplate ldapTemplate) {
    this.ldapTemplate = ldapTemplate;
  }

  public String findLdapUidByUsername(String username) {
    String filter = "(uid=" + username + ")";
    List<String> results = ldapTemplate.search(
      "",
      filter,
      (AttributesMapper<String>) attrs -> (String) attrs.get("uid").get()
    );
    if (!results.isEmpty()) {
      return results.get(0);
    }
    return null;
  }
}
