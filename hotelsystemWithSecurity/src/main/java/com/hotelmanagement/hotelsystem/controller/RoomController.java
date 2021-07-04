package com.hotelmanagement.hotelsystem.controller;

import com.hotelmanagement.hotelsystem.dao.RoomDao;
import com.hotelmanagement.hotelsystem.entity.RoomDetails;
import com.hotelmanagement.hotelsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;

    //Enter room details
    @PostMapping("/enter-room-details")
    public RoomDetails addRoomDetails(@RequestBody RoomDetails roomDetails){
        return roomService.addRoomDetails(roomDetails);

    }

    //Get Single room
    @GetMapping("/show-single-room-details/{roomId}")
    public RoomDetails showSingleRoomDetails(@PathVariable Long roomId){
        return roomService.showSingleRoomDetails(roomId);
    }

    //Show room details
    @GetMapping("/show-room-details")
    public List<RoomDetails> showRoomDetails(){
        return roomService.showRoomDetails();
    }

    //update room details
    @PutMapping("/update-room-details")
    public RoomDetails updateRoomDetails(@RequestBody RoomDetails roomDetails){
        return roomService.updateRoomDetails(roomDetails);
    }


    //Delete room details
    @DeleteMapping("/delete-room-details/{roomNo}")
    public ResponseEntity<HttpStatus> deleteRoomDetails(@PathVariable Long roomNo){
       try {
           roomService.deleteRoomDetails(roomNo);
           return new ResponseEntity<>(HttpStatus.OK);
       } catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

}
