package com.example.uberHttpBackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Result {
    private String status;//响应码，0代表成功；error code 代表失败
    private String msg;
    private Object data; //返回的数据

    public static Result success () {
        return new Result ("0", "success", null);
    }
    public static Result success (Object data) {
        return new Result ("0", "success", data) ;
    }
    public static Result error (String msg) {
        return new Result ("error code", msg, null) ;
    }

}