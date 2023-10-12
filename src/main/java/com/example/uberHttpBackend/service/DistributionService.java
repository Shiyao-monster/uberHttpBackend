package com.example.uberHttpBackend.service;

import com.example.uberHttpBackend.pojo.Driver;
import com.example.uberHttpBackend.pojo.Passenger;
import com.example.uberHttpBackend.pojo.Result;
import com.example.uberHttpBackend.pojo.Ride;

public interface DistributionService {
    // 司机端接单
    Result acceptChannel(Driver driver, String rid);

    // 乘客端创建行程
    Result createRide(Passenger passenger);

    // 乘客端取消行程
    Result cancelRide(String rid);

    // 查行程状态
    Result checkRide(String rid);
}
