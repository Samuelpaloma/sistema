package com.example.controller;

import com.example.model.user;
import com.example.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // Opcional: permite peticiones desde otros dominios
public class userController {

    @Autowired
    private userService userService;

    // ✅ Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<user> createUser(@RequestBody user u) {
        user savedUser = userService.saveUser(u);
        return ResponseEntity.ok(savedUser);
    }

    // ✅ Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<user>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // ✅ Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<user> getUserById(@PathVariable int id) {
        Optional<user> optionalUser = userService.getUserById(id);
        return optionalUser.map(ResponseEntity::ok)
                           .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<user> updateUser(@PathVariable int id, @RequestBody user updatedUser) {
        Optional<user> existingUser = userService.getUserById(id);
        if (existingUser.isPresent()) {
            updatedUser.setId(id);
            return ResponseEntity.ok(userService.saveUser(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        Optional<user> existingUser = userService.getUserById(id);
        if (existingUser.isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Buscar usuario por email (opcional)
    @GetMapping("/email/{email}")
    public ResponseEntity<user> getUserByEmail(@PathVariable String email) {
        user u = userService.getUserByEmail(email);
        if (u != null) {
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
