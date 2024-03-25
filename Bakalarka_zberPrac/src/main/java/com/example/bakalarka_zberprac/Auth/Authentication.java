package com.example.bakalarka_zberprac.Auth;

import com.example.bakalarka_zberprac.entity.UcitelEntity;
import com.example.bakalarka_zberprac.Repository.ucitelRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.ldap.core.LdapTemplate;

public class Authentication implements UserAuth {

  private final HttpSessUserAuth httpSession;
  private final ucitelRepository ucitelRepository;
  private final LdapTemplate ldapTemplate;

  public Authentication(HttpSession httpSession, ucitelRepository ucitelRepository, LdapTemplate ldapTemplate) {
    this.httpSession = new HttpSessUserAuth(httpSession, ucitelRepository);
    this.ucitelRepository = ucitelRepository;
    this.ldapTemplate = ldapTemplate;
  }

  @Override
  public boolean login(String login, String pass) {
    UcitelEntity user = ucitelRepository.findByLogin(login);
    if (user != null && pass.equals(user.getHeslo())) {
      httpSession.login(login, pass);
      return true;
    }
    return false;
  }

  @Override
  public void logout() {
    httpSession.logout();
  }

  @Override
  public String getLoggedUsername() {
    return httpSession.getLoggedUsername();
  }

  @Override
  public Object getLoggedUserID() {
    return httpSession.getLoggedUserID();
  }

  @Override
  public Object getLoggedUserContext() {
    return httpSession.getLoggedUserContext();
  }

  @Override
  public boolean isLogged() {
    return httpSession.isLogged();
  }
}
