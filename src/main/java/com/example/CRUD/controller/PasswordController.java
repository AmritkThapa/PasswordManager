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

    @GetMapping
    public ResponseEntity<List<Password>> getAllPasswords() {
        List<Password> passwords = passwordService.getAllPasswords();
        return new ResponseEntity<>(passwords, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Password> getPasswordById(@PathVariable Long id) {
        Password password = passwordService.getPasswordById(id);
        if (password == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(password, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Password> createPassword(@RequestBody Password password) {
        Password createdPassword = passwordService.createPassword(password);
        return new ResponseEntity<>(createdPassword, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Password> updatePassword(@PathVariable Long id, @RequestBody Password password) {
        Password updatedPassword = passwordService.updatePassword(id, password);
        if (updatedPassword == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPassword, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassword(@PathVariable Long id) {
        passwordService.deletePassword(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
