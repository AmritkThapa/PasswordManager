package com.example.CRUD.dto;

import com.example.CRUD.entity.Password;
import lombok.*;

@Data

public class PasswordDto {
    private long id;
    private String username;
    private String site;
    private String pswd;

    public PasswordDto(Password savedPassword) {
    }
}
