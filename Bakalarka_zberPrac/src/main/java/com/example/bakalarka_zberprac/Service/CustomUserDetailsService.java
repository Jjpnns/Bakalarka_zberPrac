package com.example.bakalarka_zberprac.Service;

import com.example.bakalarka_zberprac.Core.User;
import com.example.bakalarka_zberprac.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    User user = userRepository.findUserByLogin(login);
    List<String> roles = new ArrayList<>();
    roles.add("USER");
    UserDetails userDetails =
      org.springframework.security.core.userdetails.User.builder()
        .username(user.getLogin())
        .password(user.getPassword())
        .roles(roles.toArray(new String[0]))
        .build();
    return userDetails;
  }
}
