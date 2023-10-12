package com.example.uberHttpBackend.controller;

import com.example.uberHttpBackend.pojo.*;
import com.example.uberHttpBackend.service.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.uberHttpBackend.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DistributionController {
    @Autowired
    private DistributionService distributionService;

    //司机端接单
    @PutMapping("/ride/{rid}")
    public Result acceptChannel(@PathVariable String rid, @RequestBody Driver driver) {
        return distributionService.acceptChannel(driver, rid);
    }

    // 乘客端创建行程
    @PostMapping("/ride")
    public Result createRide(@RequestBody Passenger passenger) {
        return distributionService.createRide(passenger);
    }
    // 乘客端取消行程
    @PutMapping("/cancelRide/{rid}")
    public Result cancelRide(@PathVariable String rid) {
        return distributionService.cancelRide(rid);
    }


    //乘客查状态状态
    @GetMapping("/ride/{rid}")
    public Result checkRide(@PathVariable String rid) {
        return distributionService.checkRide(rid);
    }
}
