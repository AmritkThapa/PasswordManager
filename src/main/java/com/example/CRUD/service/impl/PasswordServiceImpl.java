package com.example.CRUD.service.impl;

import com.example.CRUD.dto.PasswordDto;
import com.example.CRUD.entity.Password;
import com.example.CRUD.repo.PasswordRepo;
import com.example.CRUD.service.PasswordService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasswordServiceImpl implements PasswordService {
    private final PasswordRepo passwordRepo;
    @Override
    public Password createPassword(Password password) {
        Long maxId = passwordRepo.findMaxId();
        if(maxId==null){
            maxId=1L;
        }
        else {
            Long l = maxId++;
        }
        password.setId(maxId);
        return passwordRepo.save(password);
    }
    @Override
    public List<Password> getAllPasswords() {
        return passwordRepo.findAll();
    }

    @Override
    public Password getPasswordById(Long id) {
        return passwordRepo.findById(id).orElse(null);
    }

    @Override
    public Password updatePassword(Long id, Password updatedPassword) {
        updatedPassword.setId(id);
        return passwordRepo.save(updatedPassword);
    }

    @Override
    @Transactional
    public void deletePassword(Long id) {
        passwordRepo.deleteById(id);

    }


}

