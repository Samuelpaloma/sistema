package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Factura;


public interface  Ifactura extends JpaRepository
<Factura, Integer> 

{
    
}
