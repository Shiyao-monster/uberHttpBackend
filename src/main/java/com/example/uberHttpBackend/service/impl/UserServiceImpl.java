package com.example.uberHttpBackend.service.impl;


import com.example.uberHttpBackend.mapper.UserMapper;
import com.example.uberHttpBackend.pojo.Result;
import com.example.uberHttpBackend.pojo.Ride;
import com.example.uberHttpBackend.pojo.User;
import com.example.uberHttpBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserMapper userMapper;

    // 创建用户
    @Override
    public String createUser(User user) {
        if (user.getPhone() == null){
            return "Phone number required";
        } else if (user.getPassword() == null) {
            return "Password required";
        } else if (user.getRole() == null) {
            return "Role is required";
        }
        if (user.getUsername() == null) {
            String name = "username" + String.valueOf(Math.random() * 100000);
            user.setUsername(name);
        }
        user.setUID(String.valueOf(Math.random() * 100000));
        userMapper.insert(user);
        return "0";
    }

    // 用户登陆
    @Override
    public Result login(String phone, String password){
        List<User> userList = userMapper.list(phone, password);
        if (userList.isEmpty()) {
            return Result.error("User does not exist or password error");
        } else {
            return Result.success(userList);
        }
    }

    // 更新用户信息
    @Override
    public Result update(User user) {
        if(user.getCity()==""){
            return Result.error("Invalid city");
        }
        userMapper.update(user);
        List<User> userList = userMapper.listByUID(user.getUID());
        return Result.success(userList);
    }

    // 查看历史订单
    @Override
    public Result getHistory(String uID) {
        List<Ride> history = userMapper.listHistory(uID);
        return Result.success(history);
    }
}
