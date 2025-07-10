package com.example.DTO;

public class FacturaDTO {
    
    private String total;

    public FacturaDTO(){}

    public FacturaDTO(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }


    
}