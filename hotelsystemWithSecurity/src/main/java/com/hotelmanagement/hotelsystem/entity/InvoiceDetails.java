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
public class InvoiceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long invoiceId;
    private Long reservationId;
    private Long roomNo;
    private String roomType;
    private Long roomPrice;
    private Long checkInDate;
    private Long checkOutDate;
    private String mealType;
    private Long mealPrice;
    private Long totalPrice;
    private String userName;
    private String userNo;

    public InvoiceDetails(Long roomNo, String roomType, Long roomPrice, Long checkInDate, Long checkOutDate, String mealType, Long mealPrice, Long totalPrice, String userName, String userNo) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.mealType = mealType;
        this.mealPrice = mealPrice;
        this.totalPrice = totalPrice;
        this.userName = userName;
        this.userNo = userNo;
    }

}
