package com.hotelmanagement.hotelsystem.service;

import com.hotelmanagement.hotelsystem.dao.RoomDao;
import com.hotelmanagement.hotelsystem.entity.RoomDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomDao roomDao;

    public RoomDetails addRoomDetails(RoomDetails roomDetails){
        return roomDao.save(roomDetails);
    }

    public List<RoomDetails> showRoomDetails(){
        return roomDao.findAll();
    }

    public RoomDetails updateRoomDetails(RoomDetails roomDetails) {
       return roomDao.save(roomDetails);
    }

    public void deleteRoomDetails(Long roomId) {
         RoomDetails roomDetails= roomDao.getRoomByRoomNo(roomId);
         roomDao.delete(roomDetails);
    }

    public RoomDetails showSingleRoomDetails(Long roomId) {
          return roomDao.getRoomByRoomNo(roomId);
    }
}
