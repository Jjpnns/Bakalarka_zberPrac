package com.example.bakalarka_zberprac.Resp;

public class LoginRes {
  private String login;
  private String token;

  public LoginRes(String email, String token) {
    this.login = email;
    this.token = token;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }



}
