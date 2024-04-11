package com.example.CRUD.controller;

import com.example.CRUD.entity.Password;
import com.example.CRUD.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/passwords")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping
    public Password createPassword(@RequestBody Password password) {
        return passwordService.createPassword(password);
    }

    @PostMapping("/{id}")
    public Password updatePassword(@PathVariable Long id, @RequestBody Password password) {
        return passwordService.updatePassword(id, password);
    }

    @DeleteMapping("/{id}")
    public void deletePassword(@PathVariable Long id) {
        passwordService.deletePassword(id);
    }

    @GetMapping("/{id}")
    public Password getPasswordById(@PathVariable Long id) {
        return passwordService.getPasswordById(id);
    }

    @GetMapping
    public List<Password> getAllPasswords() {
        return passwordService.getAllPasswords();
    }


}
