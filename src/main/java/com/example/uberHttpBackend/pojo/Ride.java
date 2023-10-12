package com.example.uberHttpBackend.pojo;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ride {
    private String id;
    private LocalDateTime creationTime;
    private String passengerUID;
    private String driverUID;
    private String mqttChannel;
    private String rideType;
    private String startLocationGeo;
    private String startLocationAddress;
    private String endLocationGeo;
    private String endLocationAddress;
    private String status;
    private LocalDateTime driverAcceptTime;
    private LocalDateTime passengerPickupTime;
    private LocalDateTime arrivedAtDestinationTime;
    private LocalDateTime rideCancelTime;
    private double totalDistance;
    private String rideOrderFormID;
    private String alarmProcessingStatus;
    private String afterSalesStatus;
    private String rideRating;
    private String rideReviewContent;





}
