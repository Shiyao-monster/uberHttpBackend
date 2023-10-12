package com.example.uberHttpBackend.service;

import com.example.uberHttpBackend.pojo.Result;
import com.example.uberHttpBackend.pojo.User;

public interface UserService {
    // 创建用户
    String createUser(User user);

    // 用户登陆
    Result login(String phone, String token);

    // 用户更新账户信息
    Result update(User user);

    // 乘客查看历史订单
    Result getHistory(String uID);
}
