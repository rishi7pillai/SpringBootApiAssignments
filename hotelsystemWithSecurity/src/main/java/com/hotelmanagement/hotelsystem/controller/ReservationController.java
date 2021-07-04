package com.hotelmanagement.hotelsystem.controller;

import com.hotelmanagement.hotelsystem.entity.ReservationDetails;
import com.hotelmanagement.hotelsystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/enter-reservation-details")
    public ReservationDetails enterReservationDetails(@RequestBody ReservationDetails reservationDetails){
       return reservationService.enterReservationDetails(reservationDetails);
    }

    @GetMapping("/show-reservation-details")
    public List<ReservationDetails> showReservationDetails(){
        System.out.println("reservation");
        return reservationService.showReservationDetails();
    }

    @PutMapping("/update-reservation-details")
    public ReservationDetails updateReservationDetails(@RequestBody ReservationDetails reservationDetails) {
      return reservationService.updateReservationDetails(reservationDetails);
    }

    @DeleteMapping("/delete-reservation-details/{reservationId}")
    public ResponseEntity<HttpStatus> deleteReservationDetails(@PathVariable Long reservationId){
        try{
            reservationService.deleteReservationDetails(reservationId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
