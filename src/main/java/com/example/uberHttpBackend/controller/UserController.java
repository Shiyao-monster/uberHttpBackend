package com.example.uberHttpBackend.controller;


import com.example.uberHttpBackend.pojo.Result;
import com.example.uberHttpBackend.pojo.User;
import com.example.uberHttpBackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * <POST> /user
     * 创建用户，仅需要手机号、密码和角色，用户名如果未填则随机生成
     **/
    @PostMapping("/user")
    public Result createUser(@RequestBody User user) {
        String msg = userService.createUser(user);
        if (msg == "0") {
            return Result.success();
        } else {
            return Result.error(msg);
        }
    }

    //用户使用手机号和密码登陆
    @GetMapping("/login")
    public Result login(@RequestParam String phone, @RequestParam String token) {
        return userService.login(phone, token);
    }

    //用户更新账户信息
    @PutMapping("/user/{uID}")
    public Result update(@PathVariable String uID,  @RequestBody User user) {
        user.setUID(uID);
        return userService.update(user);
    }

    //用户查看历史订单
    @GetMapping("/history/{uID}")
    public Result getHistory(@PathVariable String uID) {
        return userService.getHistory(uID);
    }
    
}