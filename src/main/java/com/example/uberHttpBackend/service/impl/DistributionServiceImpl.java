package com.example.uberHttpBackend.service.impl;

import com.example.uberHttpBackend.mapper.DistributionMapper;
import com.example.uberHttpBackend.mapper.UserMapper;
import com.example.uberHttpBackend.mapper.OrderMapper;
import com.example.uberHttpBackend.pojo.*;
import com.example.uberHttpBackend.service.DistributionService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistributionServiceImpl implements DistributionService {
    @Autowired
    private DistributionMapper distributionMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    //司机端接单
    @Override
    public Result acceptChannel(Driver driver, String rid) {
        List<Ride> rideList = distributionMapper.checkRID(rid);
        Ride ride = rideList.get(0);
        if (ride.getDriverUID() != null) {
            return Result.error("This ride has been accepted by another driver");
        } else {
            userMapper.updateDriver(driver);
            String startLocationGeo = "{\"longitude\": " + driver.getLongitude() + ", \"latitude\": " + driver.getLatitude() + "}";
            String mqttChannel = "mqttChannel" + ride.getId();
            ride.setMqttChannel(mqttChannel);
            ride.setDriverUID(driver.getDriverUid());
            ride.setStartLocationGeo(startLocationGeo);
            ride.setStatus("DriverAcceptedRide");
            ride.setDriverAcceptTime(LocalDateTime.now());
            distributionMapper.acceptChannel(ride);
            return Result.success("Channel: " + mqttChannel);
        }
    }

    // 乘客端创建行程
    @Override
    public Result createRide(Passenger passenger) {
        //Error: if the passenger didn't pay for the last ride
        String recentOrderID = distributionMapper.getRecentOrderID(passenger.getUid());
        if (recentOrderID != null && recentOrderID != "") {
            List<Order> orderList = orderMapper.listByID(recentOrderID);
            String orderStatus = orderList.get(0).getStatus();
            if (orderStatus.equals("Unpaid") ) {
                return Result.error("未支付上一次行程订单");
            }
        }

        // Success
        userMapper.updatePassenger(passenger);

        String startLocationGeo = "{\"longitude\": " + passenger.getPickUpLong() + ", \"latitude\": " + passenger.getPickUpLat() + "}";
        Ride ride = new Ride();
        String rid = "rid" + String.valueOf(Math.random() * 100000);
        ride.setPassengerUID(passenger.getUid());
        ride.setStartLocationGeo(startLocationGeo);
        ride.setStartLocationAddress(passenger.getPickUpResolvedAddress());
        ride.setEndLocationAddress(passenger.getDestResolvedAddress());
        ride.setId(rid);
        ride.setRideType(String.valueOf(passenger.getType()));
        ride.setStatus("Created");
        distributionMapper.createRide(ride);
        

        return Result.success("rid: " + rid);
    }

    // 乘客端取消行程
    @Override
    public Result cancelRide(String rid) {
        List<Ride> rideList = distributionMapper.checkRID(rid);
        Ride ride = rideList.get(0);
        if (ride.getStatus().equals("Cancelled")) {
            return Result.error("Ride has been cancelled");
        } else {
            distributionMapper.cancelRide(rid, "Cancelled", LocalDateTime.now());
            return Result.success();
        }
        
    }

    // 查行程状态
    @Override
    public Result checkRide(String rid) {
        List<Ride> rideList = distributionMapper.checkRID(rid);
        Ride ride = rideList.get(0);
        return Result.success(ride);
    }
    
}
