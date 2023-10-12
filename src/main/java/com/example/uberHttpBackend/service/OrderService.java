package com.example.uberHttpBackend.service;

import com.example.uberHttpBackend.pojo.Result;
import com.example.uberHttpBackend.pojo.User;
public interface OrderService {
    // 查看行程价格
    Result orderSummary(String oid);
}
