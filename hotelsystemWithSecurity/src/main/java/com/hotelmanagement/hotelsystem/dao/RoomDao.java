package com.hotelmanagement.hotelsystem.dao;

import com.hotelmanagement.hotelsystem.entity.RoomDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao extends JpaRepository<RoomDetails, Long>{

    //select the data which has same id as roomId
    @Query("select r from RoomDetails r where r.roomId= :roomId")
    public RoomDetails getRoomByRoomNo(@Param("roomId") Long roomId);
}
