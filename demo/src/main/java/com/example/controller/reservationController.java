package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.ReservationDTO;
import com.example.DTO.responseDTO;
import com.example.model.Mesa;
import com.example.model.Reservation;
import com.example.service.ReservationService;

@RestController
@RequestMapping("/api/v1/reservation")
public class reservationController {

    @Autowired
    private ReservationService reservationService;

    // Obtener todas las reservas
    @GetMapping("/")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.findAll();
        return ResponseEntity.ok(reservations);
    }

    // Obtener mesas disponibles
    @GetMapping("/available-mesas")
    public ResponseEntity<List<Mesa>> getAvailableMesas() {
        List<Mesa> mesas = reservationService.findAvailableMesas();
        return ResponseEntity.ok(mesas);
    }

    // Agregar una nueva reserva
    @PostMapping("/")
    public ResponseEntity<Object> addReservation(@RequestBody ReservationDTO reservationDTO) {
        try {
            responseDTO response = reservationService.addReservation(reservationDTO);
            if (response.getStatus().equals("200 OK")) {
                return ResponseEntity.ok(response.getMessage());
            } else {
                return ResponseEntity.badRequest().body(response.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor: " + e.getMessage());
        }
    }
}