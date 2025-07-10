package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.DTO.ProovedorDTO;
import com.example.DTO.responseDTO;
import com.example.model.Proovedor;
import com.example.repository.Iproovedor;

@Service
public class ProovedorService {

    @Autowired
    private Iproovedor proovedorRepository;

    // Obtener todos los proveedores
    public List<Proovedor> findAll() {
        return proovedorRepository.findAll();
    }

    // Agregar un nuevo proveedor
    public responseDTO addProovedor(ProovedorDTO proovedorDTO) {
        Proovedor proovedor = new Proovedor(
            0, // ID autogenerado
            proovedorDTO.getName(),
            proovedorDTO.getTelefono(),
            proovedorDTO.getDireccion()
        );

        proovedorRepository.save(proovedor);

        return new responseDTO(
            HttpStatus.OK.toString(),
            "Proveedor agregado correctamente"
        );
    }

    // Eliminar un proveedor por ID
    public responseDTO deleteProovedor(int id) {
        Optional<Proovedor> proovedorOptional = proovedorRepository.findById(id);

        if (!proovedorOptional.isPresent()) {
            return new responseDTO(
                HttpStatus.NOT_FOUND.toString(),
                "El proveedor con ID " + id + " no existe"
            );
        }

        proovedorRepository.deleteById(id);

        return new responseDTO(
            HttpStatus.OK.toString(),
            "Proveedor eliminado correctamente"
        );
    }
}