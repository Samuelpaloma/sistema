package com.example.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="factura")
public class Factura {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_factura")
    private int idFactura;

    @Column(name="fecha", nullable=false)
    private LocalDate fecha;

    @Column(name="total", nullable=false)
    private String total;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private user user;

    // Constructor vacío requerido por JPA
    public Factura() {
    }

    // Constructor con parámetros
    public Factura(int idFactura, LocalDate fecha, String total, user user) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.total = total;
        this.user = user;
    }

    // Getters y Setters
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }
}
