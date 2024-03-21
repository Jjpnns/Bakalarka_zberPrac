package com.example.bakalarka_zberprac.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private final LdapService ldapService;

  @Autowired
  public LoginService(LdapService ldapService) {
    this.ldapService = ldapService;
  }

  public boolean login(String username, String password) {
    if (ldapService.authenticate(username, password)) {
      // Ak je autentifikácia úspešná, overíme, či je používateľ učiteľom
      return ldapService.isTeacher(username);
    } else {
      // Ak autentifikácia zlyhá, vrátime false
      return false;
    }
  }

  //pridat autent
}

