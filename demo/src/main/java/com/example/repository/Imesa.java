package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Mesa;

public interface Imesa extends JpaRepository<Mesa, Integer> {

        // Método para encontrar mesas disponibles
        List<Mesa> findByOcupada(boolean ocupada);
}