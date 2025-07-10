package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.PedidoDTO;
import com.example.model.Pedido;
import com.example.repository.Ipedido;

@Service
public class PedidoService {
    
    @Autowired
    private Ipedido data;
    
    public void save(PedidoDTO pedidoDTO){
        Pedido pedidoRegister = convertToModel(pedidoDTO);
        data.save(pedidoRegister);
    }

    public PedidoDTO convertToDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO(
            pedido.getEstado()
        );
        return pedidoDTO;
    }
    
    public Pedido convertToModel(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido(
            0,
            pedidoDTO.getEstado());
        return pedido;
    }
}
