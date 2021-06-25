package com.hotelmanagement.hotelsystem.dao;

import com.hotelmanagement.hotelsystem.entity.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDao extends JpaRepository<InvoiceDetails,Long> {

    @Query("select r from InvoiceDetails r where r.reservationId=:reservationId")
    public InvoiceDetails getInvoiceByReservation(@Param("reservationId") Long reservationId);
}
