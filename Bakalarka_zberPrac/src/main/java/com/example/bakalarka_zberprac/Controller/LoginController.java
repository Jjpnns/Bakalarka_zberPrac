package com.example.bakalarka_zberprac.Controller;

import com.example.bakalarka_zberprac.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
      this.loginService = loginService;
    }

    @GetMapping("/LoginLdap")
  public ResponseEntity<String> LoginLdap(@RequestParam("ldapID") String uid, @RequestParam("pass") String pass)  {
      return loginService.LoginLdap(uid,pass);
  }

  

  }


