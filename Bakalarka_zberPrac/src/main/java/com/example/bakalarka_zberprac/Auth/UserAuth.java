package com.example.bakalarka_zberprac.Auth;

public interface UserAuth {
  boolean login(String login, String pass);

  void logout();

  String getLoggedUsername();

  Object getLoggedUserID();

  Object getLoggedUserContext();

  boolean isLogged();



}
