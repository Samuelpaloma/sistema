package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Employee;

public interface  Iemployee extends JpaRepository
<Employee, Integer> 

{
    
}