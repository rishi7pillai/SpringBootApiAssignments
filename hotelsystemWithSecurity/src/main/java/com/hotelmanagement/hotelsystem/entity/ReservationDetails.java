package com.hotelmanagement.hotelsystem.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationDetails {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
   private Long reservationId;
   private Long roomId;
   private Long mealId;
   private Long checkInDate;
   private Long checkOutDate;
   private String userName;
   private String userEmail;
   private String userNo;
   private String userAddress;

    public ReservationDetails(Long roomId, Long checkInDate, Long checkOutDate, String userName, String userEmail, String userNo, String userAddress) {
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userNo = userNo;
        this.userAddress = userAddress;
    }
}
