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
    return ucitelService.getAllUcitel();
  }

  @GetMapping("/{login}") // Zmena názvu parametra
  public UcitelEntity getUcitelByLogin(@PathVariable String login) { // Zmena názvu metódy
    return ucitelService.getUcitelByLogin(login); // Zmena volania metódy
  }

  @PostMapping("/")
  public UcitelEntity createUcitel(@RequestBody UcitelEntity ucitelEntity) {
    return ucitelService.createUcitel(ucitelEntity);
  }

  @PutMapping("/")
  public UcitelEntity updateUcitel(@RequestBody UcitelEntity ucitelEntity) {
    return ucitelService.updateUcitel(ucitelEntity);
  }

  @DeleteMapping("/")
  public void deleteAllUcitelia() {
    ucitelService.deleteAllUcitel();
  }

  /*@DeleteMapping("/{id}")
  public void deleteUcitel(@PathVariable Long id) {
    ucitelService.deleteUcitel(id);
  }
  */

}
