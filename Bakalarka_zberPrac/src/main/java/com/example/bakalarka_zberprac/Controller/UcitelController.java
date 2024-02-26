package com.example.bakalarka_zberprac.Controller;

import com.example.bakalarka_zberprac.Service.UcitelService;
import com.example.bakalarka_zberprac.entity.UcitelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/ucitel")
public class UcitelController {
    @Autowired
    private UcitelService ucitelService;

    // Create a new user
    @PostMapping
    public UcitelEntity createUcitel(@RequestBody UcitelEntity user) {
        return UcitelService.createUcitel(user);
    }

    // Get all users
    @GetMapping
    public List<UcitelEntity> getAllUsers() {
        return ucitelService.getAllUcitel();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public Optional<UcitelEntity> getUserById(@PathVariable Long id) {
        return ucitelService.getUcitelById(id);
    }

    // Update user by ID
    @PutMapping("/{id}")
    public UcitelEntity updateUcitel(@PathVariable Long id, @RequestBody UcitelEntity user) {
        return ucitelService.updateUcitel(id, user);
    }

    // Delete all users
    @DeleteMapping
    public String deleteAllUcitel() {
        ucitelService.deleteAllUcitel();
        return "All users have been deleted successfully.";
    }

    // Delete user by ID
    @DeleteMapping("/{id}"
    public void deleteUcitel(@PathVariable Long id) {
        ucitelService.deleteUcitel(id);

    }
}