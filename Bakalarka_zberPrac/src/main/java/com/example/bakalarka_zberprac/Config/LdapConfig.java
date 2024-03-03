package com.example.bakalarka_zberprac.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.core.support.SimpleDirContextAuthenticationStrategy;

@Configuration
public class LdapConfig {

  @Bean
  public ContextSource contextSource() {
    LdapContextSource contextSource = new LdapContextSource();
    contextSource.setUrl("ldap://pegasus.fri.uniza.sk:389");
    contextSource.setUserDn("CN=ki_web,OU=Aplikacie,DC=fri,DC=uniza,DC=sk");
    contextSource.setPassword("le5130va");
    contextSource.afterPropertiesSet();
    contextSource.setAuthenticationStrategy(new SimpleDirContextAuthenticationStrategy());

    return contextSource;

  }
}
