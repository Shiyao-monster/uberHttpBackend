package com.example.uberHttpBackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String uID;
    private String phone ;
    private String role ;
    private String password ;
    private String username ;
    private String licensePlate ;
    private String vehicleType ;
    private double totalTravelDistance ;
    private String province ;
    private String city ;
}
