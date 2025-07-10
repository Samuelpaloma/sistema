package com.example.DTO;

public class PedidoDTO {
    private String estado;

    public PedidoDTO(){}

    public PedidoDTO(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}

