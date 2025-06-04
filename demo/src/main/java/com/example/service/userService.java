package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.user;
import com.example.repository.userRepository;

@Service
public class userService {

    @Autowired
    private userRepository userRepository;

    // Crear o actualizar usuario
    public user saveUser(user u) {
        return userRepository.save(u);
    }

    // Obtener todos los usuarios
    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    // Buscar usuario por ID
    public Optional<user> getUserById(int id) {
        return userRepository.findById(id);
    }

    // Eliminar usuario por ID
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    // Buscar por email (ejemplo de método personalizado)
    public user getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
