package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Proovedor;

public interface  Iproovedor extends JpaRepository
<Proovedor, Integer> 

{
    
}
