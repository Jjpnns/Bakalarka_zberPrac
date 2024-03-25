package com.example.bakalarka_zberprac.Service;

import com.example.bakalarka_zberprac.entity.UcitelEntity;
import com.example.bakalarka_zberprac.Repository.ucitelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UcitelService {

  private final ucitelRepository ucitelRepository;

  @Autowired
  public UcitelService(ucitelRepository ucitelRepository) {
    this.ucitelRepository = ucitelRepository;
  }

  public UcitelEntity pridajUcitela(String meno, String priezvisko, String login, String heslo, Boolean jeadmin) {
    UcitelEntity ucitel = new UcitelEntity();
    ucitel.setMeno(meno);
    ucitel.setPriezvisko(priezvisko);
    ucitel.setLogin(login);
    ucitel.setHeslo(heslo);
    ucitel.setJeadmin(jeadmin);
    return ucitelRepository.save(ucitel);
  }

  public void vymazUcitela(int idUcitel) {
    ucitelRepository.deleteById(idUcitel);
  }

  public List<UcitelEntity> vypisVsetkychUcitelov() {
    return ucitelRepository.findAll();
  }
}
