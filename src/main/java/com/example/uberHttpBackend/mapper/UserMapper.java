package com.example.uberHttpBackend.mapper;

import com.example.uberHttpBackend.pojo.Driver;
import com.example.uberHttpBackend.pojo.Passenger;
import com.example.uberHttpBackend.pojo.Ride;
import com.example.uberHttpBackend.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    // 注册用户
    @Insert("Insert Into User (uID, phone, role, password, username) VALUES (#{uID}, #{phone}, #{role}, #{password}, #{username})")
    void insert(User user);

    /**
     * login check
     * @return
     */
    List<User> list(String phone, String password);

    /**
     * update user info
     */
    void update(User user);

    // 查看用户信息
    @Select("Select * From User Where uID = #{uID}")
    List<User> listByUID(String uID);

    // 更新司机信息
    @Update("Update User Set licensePlate = #{numberPlate}, vehicleType = #{vehicleInfo} Where uID = #{driverUid}")
    void updateDriver(Driver driver);

    // 更新乘客信息
    @Update("Update User Set province = #{province}, city = #{city} Where uID = #{uid}")
    void updatePassenger(Passenger passenger);
    
    // 乘客端查看历史订单
    @Select("Select * From Ride Where passengerUID = #{uID}")
    List<Ride> listHistory(String uID);
}
