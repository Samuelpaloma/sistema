package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.user;

public interface userRepository extends JpaRepository<user, Integer> {
    // Puedes agregar métodos personalizados si lo necesitas
    user findByEmail(String email);
}