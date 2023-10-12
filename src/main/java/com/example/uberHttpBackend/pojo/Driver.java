package com.example.uberHttpBackend.pojo;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    private String driverUid;
    private double longitude;
    private double latitude;
    private String numberPlate;
    private String vehicleInfo;
}
