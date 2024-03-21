package com.example.bakalarka_zberprac.Repository;

import com.example.bakalarka_zberprac.Core.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
  public User findUserByLogin(String login){
    User user = new User(login,"123456");
    user.setFirstName("FirstName");
    user.setLastName("LastName");
    return user;
  }
}
