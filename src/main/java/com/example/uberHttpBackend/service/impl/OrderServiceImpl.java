package com.example.uberHttpBackend.service.impl;

import com.example.uberHttpBackend.mapper.OrderMapper;
import com.example.uberHttpBackend.service.OrderService;
import com.example.uberHttpBackend.pojo.Result;
import com.example.uberHttpBackend.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    // 查看行程价格
    @Override
    public Result orderSummary(String oid) {
        if(oid==""){
            return Result.error("invalid oid");
        }
        List<Order> orderList = orderMapper.listByID(oid);
        return Result.success(orderList);
    }
}
