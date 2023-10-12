package com.example.uberHttpBackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    private String uid;
    private double pickUpLong;
    private double pickUpLat;
    private String pickUpResolvedAddress;
    private String destResolvedAddress;
    private int type;
    private String province;
    private String city;
}
