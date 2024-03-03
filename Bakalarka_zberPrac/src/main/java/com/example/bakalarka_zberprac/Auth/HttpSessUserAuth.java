package com.example.bakalarka_zberprac.Auth;

import com.example.bakalarka_zberprac.entity.UcitelEntity;
import com.example.bakalarka_zberprac.Repository.ucitelRepository;
import jakarta.servlet.http.HttpSession;

public class HttpSessUserAuth implements UserAuth {

private final HttpSession httpSession;
private final ucitelRepository ucitelRepository;


public HttpSessUserAuth(HttpSession httpSession, ucitelRepository ucitelRepository) {
  this.httpSession = httpSession;
  this.ucitelRepository = ucitelRepository;

}



  @Override
  public boolean login(String login, String pass) {
  UcitelEntity user = ucitelRepository.findByLogin(login);
   if(user != null && pass.equals(user.getHeslo())) {
     httpSession.setAttribute("user",user);
     return true;
   }
   return false;
  }

  @Override
  public void logout() {
      httpSession.removeAttribute("user");
  }

  @Override
  public String getLoggedUsername() {
   Object user = httpSession.getAttribute("user");
   if( user != null) {
     return (String) user;
   } else {
     throw  new RuntimeException("Nikto nie je prihlasený");
   }
  }

  @Override
  public Object getLoggedUserID() {
    Object user = httpSession.getAttribute("user");
    if (user instanceof UcitelEntity) {
      return ((UcitelEntity) user).getIdUcitel();
    } else {
      throw new RuntimeException("ID usera nebolo najdene");
    }
  }

  @Override
  public Object getLoggedUserContext() {
    return null;
  }

  @Override
  public boolean isLogged() {
    return  httpSession.getAttribute("user") != null;
  }
  }
