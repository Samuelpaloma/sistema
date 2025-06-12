package com.example.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoleDTO {
    @JsonProperty("id")
    private int roleid;
    private String name;
    private String description;

    
}
