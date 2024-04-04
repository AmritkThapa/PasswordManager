package com.example.CRUD.service;

import com.example.CRUD.dto.PasswordDto;
import com.example.CRUD.entity.Password;

import java.util.List;

public interface PasswordService {

    List<Password> getAllPasswords();
    Password getPasswordById(Long id);
    Password createPassword(Password password);
    Password updatePassword(Long id, Password updatedPassword);
    void deletePassword(Long id);

}
