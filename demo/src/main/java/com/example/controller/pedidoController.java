package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.PedidoDTO;
import com.example.service.PedidoService;

@RestController
@RequestMapping("/api/v1/pedido")

public class pedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/")
    public ResponseEntity<Object> registerPedido(@RequestBody PedidoDTO pedido){
        pedidoService.save(pedido);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    
}
