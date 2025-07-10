package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.DetallePedidoDTO;
import com.example.model.DetallePedido;
import com.example.repository.IdetallePedido;

@Service
public class DetallePedidoService {
    

    @Autowired
    private IdetallePedido data;


    public void save(DetallePedidoDTO detallePedidoDTO){
        DetallePedido detallePedidoRegister = convertToModel(detallePedidoDTO);
        data.save(detallePedidoRegister);
    }

    public DetallePedidoDTO convertToDTO(DetallePedido detallePedido) {
        DetallePedidoDTO detallePedidoDTO = new DetallePedidoDTO(
            detallePedido.getCantidad(),
            detallePedido.getCargo(),
            detallePedido.getSalario(),
            detallePedido.getTelefono()
        );
        return detallePedidoDTO;
    }
    
    public DetallePedido convertToModel(DetallePedidoDTO detallePedidoDTO) {
        DetallePedido detallePedido = new DetallePedido(
            0,
            detallePedidoDTO.getCantidad(),
            detallePedidoDTO.getCargo(),
            detallePedidoDTO.getSalario(),
            detallePedidoDTO.getTelefono(),
            null,
            null
        );
        return detallePedido;
    }
}
