package com.hotelmanagement.hotelsystem.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="ROOMDETAIL")
public class RoomDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomId;
    @NotNull
    private Long roomNo;
    @NotBlank(message = "room type can't be blank")
    private String roomType;
    private String roomStatus;
    @NotBlank(message = "room price can't be blank")
    private Long roomPrice;

    public RoomDetails(Long roomNo, String roomType, String roomStatus) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
    }
}
