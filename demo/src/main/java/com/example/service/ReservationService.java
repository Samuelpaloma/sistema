package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.DTO.ReservationDTO;
import com.example.DTO.responseDTO;
import com.example.model.Mesa;
import com.example.model.Reservation;
import com.example.repository.Imesa;
import com.example.repository.Ireservation;

@Service
public class ReservationService {

    @Autowired
    private Ireservation reservationRepository;

    @Autowired
    private Imesa mesaRepository;

    // Obtener todas las reservas
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    // Obtener mesas disponibles
    public List<Mesa> findAvailableMesas() {
        return mesaRepository.findByOcupada(false); // Solo mesas no ocupadas
    }

    // Agregar una nueva reserva
    public responseDTO addReservation(ReservationDTO reservationDTO) {
        // Verificar si la mesa existe y está disponible
        Optional<Mesa> mesaOptional = mesaRepository.findById(reservationDTO.getIdMesa());

        if (!mesaOptional.isPresent()) {
            return new responseDTO(
                HttpStatus.BAD_REQUEST.toString(),
                "La mesa seleccionada no existe"
            );
        }

        Mesa mesa = mesaOptional.get();

        if (mesa.isOcupada()) {
            return new responseDTO(
                HttpStatus.BAD_REQUEST.toString(),
                "La mesa seleccionada no está disponible"
            );
        }

        // Crear la reserva
        Reservation reservation = new Reservation(
            0,
            reservationDTO.getName(),
            reservationDTO.getFecha(),
            reservationDTO.getNumeroPersonas(),
            Integer.parseInt(reservationDTO.getNumeroCelular()),
            mesa,
            true // Estado de la reserva (activa)
        );

        // Guardar la reserva y actualizar el estado de la mesa
        try {
            mesa.setOcupada(true); // Marcar la mesa como ocupada
            reservationRepository.save(reservation);
            mesaRepository.save(mesa);

            return new responseDTO(
                HttpStatus.OK.toString(),
                "Reserva agregada correctamente"
            );
        } catch (Exception e) {
            return new responseDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                "Error al guardar la reserva: " + e.getMessage()
            );
        }
    }
}