package com.example.uberHttpBackend.controller;

import com.example.uberHttpBackend.pojo.*;
import com.example.uberHttpBackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;



    // 单次行程结束时价格总结
    @GetMapping("/order/{oid}")
    public Result orderSummary(@PathVariable String oid) {
        return orderService.orderSummary(oid);
    }
}
