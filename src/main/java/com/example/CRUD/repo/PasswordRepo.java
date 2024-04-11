package com.example.CRUD.repo;

import com.example.CRUD.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PasswordRepo extends JpaRepository<Password,Integer> {
    Password getById(long id);
    String deleteById(long id);
    Optional<Password> findById(Long id);
    @Query("SELECT MAX(p.id) FROM Password p")
    Long findMaxId();
}
