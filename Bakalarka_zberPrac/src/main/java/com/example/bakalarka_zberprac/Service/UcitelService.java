package com.example.bakalarka_zberprac.Service;

import com.example.bakalarka_zberprac.Service.LdapService;
import com.example.bakalarka_zberprac.entity.UcitelEntity;
import com.example.bakalarka_zberprac.Repository.ucitelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UcitelService implements UserDetailsService {

  private final ucitelRepository ucitelRepository;
  private final LdapService ldapService;

  @Autowired
  public UcitelService(ucitelRepository ucitelRepository, LdapService ldapService) {
    this.ucitelRepository = ucitelRepository;
    this.ldapService = ldapService;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Skúsi najprv vyhľadať používateľa podľa prihlasovacieho mena
    UcitelEntity ucitelEntity = ucitelRepository.findByLogin(username);

    // Ak neexistuje používateľ s daným prihlasovacím menom, skúsi vyhľadať podľa emailu
    if (ucitelEntity == null) {
      ucitelEntity = ucitelRepository.findByMeno(username);
      if (ucitelEntity == null) {
        throw new UsernameNotFoundException("Používateľ s používateľským menom alebo emailom " + username + " nebol nájdený.");
      }
    }

    // Vytvorí sa UserDetails objekt na základe informácií z UcitelEntity
    List<String> roles = new ArrayList<>();
    // Pridajte roly podľa potreby
    roles.add("USER");
    return org.springframework.security.core.userdetails.User.builder()
      .username(ucitelEntity.getLogin()) // Tu záleží, či preferujete prihlasovacie meno alebo email
      .password(ucitelEntity.getHeslo())
      .roles(roles.toArray(new String[0]))
      .build();
  }



  public UcitelEntity createUcitel(UcitelEntity ucitelEntity) {
    return ucitelRepository.save(ucitelEntity);
  }

  public UcitelEntity updateUcitel(UcitelEntity updatedUcitel) {
    UcitelEntity existingUcitel = ucitelRepository.findByIdUcitel(updatedUcitel.getIdUcitel());

    if (existingUcitel != null) {
      existingUcitel.setMeno(updatedUcitel.getMeno());
      existingUcitel.setPriezvisko(updatedUcitel.getPriezvisko());
      existingUcitel.setLogin(updatedUcitel.getLogin());
      existingUcitel.setHeslo(updatedUcitel.getHeslo());
      existingUcitel.setJeadmin(updatedUcitel.getJeadmin());

      return ucitelRepository.save(existingUcitel);
    } else {
      throw new IllegalArgumentException("Učiteľ s ID " + updatedUcitel.getIdUcitel() + " neexistuje.");
    }
  }

  public List<UcitelEntity> getAllUcitel() {
    return ucitelRepository.findAll();
  }

  public UcitelEntity getUcitelByLogin(String login) {
    UcitelEntity ucitelEntity = ucitelRepository.findByLogin(login);
    if (ucitelEntity == null) {
      List<String> ldapUid = ldapService.findLdapUidByUsername(login);
      if (ldapUid != null) {
        ucitelEntity = new UcitelEntity();
        ucitelEntity.setLogin(login);
        return ucitelRepository.save(ucitelEntity);
      }
    }
    return ucitelEntity;
  }



  public void deleteAllUcitel() {
    ucitelRepository.deleteAll();
  }

  public void deleteUcitel(Integer id) {
    ucitelRepository.deleteById(id);
  }
}


