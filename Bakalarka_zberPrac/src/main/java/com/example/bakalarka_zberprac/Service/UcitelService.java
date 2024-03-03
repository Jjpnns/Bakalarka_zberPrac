package com.example.bakalarka_zberprac.Service;

import com.example.bakalarka_zberprac.entity.UcitelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UcitelService {
  @Autowired
  private com.example.bakalarka_zberprac.Repository.ucitelRepository ucitelRepository;

  @Autowired
  private LdapService ldapService;

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

  public UcitelEntity getUcitelByLogin(String login) { // Zmena názvu metódy
    UcitelEntity ucitelEntity = ucitelRepository.findByLogin(login); // Zmena volania metódy
    if (ucitelEntity == null) {
      String ldapUid = ldapService.findLdapUidByUsername(login);
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

  public void deleteUcitel(Long id) {
    ucitelRepository.deleteById(id);
  }
}
