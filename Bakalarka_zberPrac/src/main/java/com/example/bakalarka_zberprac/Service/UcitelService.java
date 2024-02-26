package com.example.bakalarka_zberprac.Service;

import com.example.bakalarka_zberprac.entity.UcitelEntity;
import com.example.bakalarka_zberprac.repository.ucitelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UcitelService {
    @Autowired
    private ucitelRepository ucitelRepository;

    // Create a new user
    public UcitelEntity createUcitel(UcitelEntity user) {

        return ucitelRepository.save(user);
    }

    // Get all users
    public List<UcitelEntity> getAllUcitel() {

        return ucitelRepository.findAll();
    }

    // Get user by ID
    public Optional<UcitelEntity> getUcitelById(Long id) {

        return ucitelRepository.findById(id);
    }

    // Update user
    public UcitelEntity updateUcitel(Long id, UcitelEntity userDetails) {
        Optional<UcitelEntity> user = ucitelRepository.findById(id);
        if (user.isPresent()) {
            UcitelEntity existingUser = user.get();
            existingUser.setMeno(userDetails.getMeno());
            existingUser.setPriezvisko(userDetails.getPriezvisko());
            return ucitelRepository.save(existingUser);
        }
        return null;
    }

    // Delete all users
    public void deleteAllUcitel() {

        ucitelRepository.deleteAll();
    }

    // Delete user
    public void deleteUcitel(Long id) {

        ucitelRepository.deleteById(id);
    }

    // Other business logic related to users
}