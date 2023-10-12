package com.example.uberHttpBackend.pojo;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private String relatedRideID;
    private LocalDateTime creationTime;
    private double totalPrice;
    private double basePrice;
    private double rideAndFuelFee;
    private double timeFee;
    private double specialLocationFee;
    private double dynamicPrice;
    private String status;
    private String paymentPlatform;
    private String paymentTransactionID;
    private String paymentResult;

    
}
