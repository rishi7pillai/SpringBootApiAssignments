package com.hotelmanagement.hotelsystem.dao;

import com.hotelmanagement.hotelsystem.entity.ReservationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationDao extends JpaRepository<ReservationDetails,Long> {

    @Query("select r from ReservationDetails r where r.reservationId=:reservationId")
    public ReservationDetails findReservationById(@Param("reservationId") Long reservationId);


}
