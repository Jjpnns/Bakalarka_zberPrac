package com.example.bakalarka_zberprac.Req;


public class LoginReq {
  private String login;
  private String password;

  public LoginReq(String username, String password) {
    this.login = username;
    this.password = password;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
