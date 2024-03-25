package com.example.bakalarka_zberprac.Controller;

import com.example.bakalarka_zberprac.entity.UcitelEntity;
import com.example.bakalarka_zberprac.Service.UcitelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ucitelia")
public class UcitelController {
  @Autowired
  private UcitelService ucitelService;

  @GetMapping("/")
  public List<UcitelEntity> getAllUcitelia() {
    return ucitelService.vypisVsetkychUcitelov();
  }

//  @GetMapping("/{login}") // Zmena názvu parametra
//  public UcitelEntity getUcitelByLogin(@PathVariable String login) { // Zmena názvu metódy
//    return ucitelService.; // Zmena volania metódy
//  }

  @PostMapping("/")
  public UcitelEntity createUcitel(@RequestBody String meno, String priezvisko, String login, String heslo, Boolean jeadmin) {
    return ucitelService.pridajUcitela(meno, priezvisko, login, heslo, jeadmin);
  }

//  @PutMapping("/")
//  public UcitelEntity updateUcitel(@RequestBody UcitelEntity ucitelEntity) {
//    return ucitelService.;
//  }

  @DeleteMapping("/")
  public void deleteAllUcitelia(int idUcitel) {
    ucitelService.vymazUcitela(idUcitel);
  }

  /*@DeleteMapping("/{id}")
  public void deleteUcitel(@PathVariable Long id) {
    ucitelService.deleteUcitel(id);
  }
  */

}
