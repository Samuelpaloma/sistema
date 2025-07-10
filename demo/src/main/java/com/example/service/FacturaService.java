package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.FacturaDTO;
import com.example.model.Factura;
import com.example.repository.Ifactura;

@Service
public class FacturaService {
    

    @Autowired
    private Ifactura data; 

    public void save(FacturaDTO facturaDTO){
        Factura facturaRegister = convertToModel(facturaDTO);
        data.save(facturaRegister);
    }

    public FacturaDTO convertToDTO(Factura factura) {
        FacturaDTO facturaDTO = new FacturaDTO(
            factura.getTotal()
        );
        return facturaDTO;
    }
    
    public Factura convertToModel(FacturaDTO facturaDTO) {
        Factura factura = new Factura(
            0,
            null,
            facturaDTO.getTotal(),
            null
        );
        return factura;
    }
}
