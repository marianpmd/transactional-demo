package com.example.transactionaldemo.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PersonsDTO {
    private Long id;
    private String address;
    private String name;
    private List<RolesDTO> roles;
}
