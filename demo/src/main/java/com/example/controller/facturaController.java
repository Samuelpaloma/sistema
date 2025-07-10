package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.FacturaDTO;
import com.example.service.FacturaService;

@RestController
@RequestMapping("/api/v1/factura")

public class facturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping("/")
    public ResponseEntity<Object> registerFactura(@RequestBody FacturaDTO factura){
        facturaService.save(factura);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    
}
