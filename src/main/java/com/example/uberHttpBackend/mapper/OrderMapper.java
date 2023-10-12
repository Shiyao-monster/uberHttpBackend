package com.example.uberHttpBackend.mapper;
import com.example.uberHttpBackend.pojo.Ride;
import com.example.uberHttpBackend.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;
@Mapper
public interface OrderMapper {
    // 查看行程订单
    @Select("Select * From OrderForm Where id = #{oid}")
    List<Order> listByID(String oid);

}
