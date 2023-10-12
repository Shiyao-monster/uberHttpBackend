package com.example.uberHttpBackend.mapper;

import com.example.uberHttpBackend.pojo.Ride;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DistributionMapper {
    // 查看行程by rideID
    @Select("Select * From Ride Where id = #{id}")
    List<Ride> checkRID(String id);

    // 司机端接单
    @Update("Update Ride Set driverUID = #{driverUID}, driverLocationGeo = #{startLocationGeo}, driverAcceptTime = #{driverAcceptTime}, mqttChannel = #{mqttChannel}, status = #{status} Where id = #{id}")
    void acceptChannel(Ride ride);

    // 乘客端创建行程
    @Insert("Insert Into Ride (id, creationTime, passengerUID, rideType, startLocationGeo, startLocationAddress, endLocationAddress, status) VALUES (#{id}, #{creationTime}, #{passengerUID}, #{rideType}, #{startLocationGeo}, #{startLocationAddress}, #{endLocationAddress}, #{status})")
    void createRide(Ride ride);

    // 乘客端取消行程
    @Update("Update Ride Set status = #{status}, rideCancelTime = #{rideCancelTime} Where id = #{id}")
    void cancelRide(String id, String status, LocalDateTime rideCancelTime);


    /**
     * 获取乘客最近行程订单ID
     * @return
     */
    String getRecentOrderID(String passengerUID);


}
