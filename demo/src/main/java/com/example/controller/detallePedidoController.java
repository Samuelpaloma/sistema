package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.DetallePedidoDTO;
import com.example.service.DetallePedidoService;

@RestController
@RequestMapping("/api/v1/detallePedido")

public class detallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @PostMapping("/")
    public ResponseEntity<Object> registerDetallePedido(@RequestBody DetallePedidoDTO detallePedido){
        detallePedidoService.save(detallePedido);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    
}
