package com.example.bakalarka_zberprac.Controller;

import com.example.bakalarka_zberprac.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
      this.loginService = loginService;
    }

  @GetMapping("/loginnm")
  public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
    boolean loggedIn = loginService.loginnm(username, password);

    if (loggedIn) {
      return "Success"; // Vrátiť úspešnú správu, ak je prihlásenie úspešné
    } else {
      return "Failure"; // Vrátiť chybovú správu, ak prihlásenie zlyhalo
    }
  }

  }


