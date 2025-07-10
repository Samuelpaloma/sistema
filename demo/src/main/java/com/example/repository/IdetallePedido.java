package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.DetallePedido;

public interface  IdetallePedido extends JpaRepository
<DetallePedido, Integer> 

{
    
}