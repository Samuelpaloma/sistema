package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Producto;

public interface  Iproducto extends JpaRepository
<Producto, Integer> 

{
    
}