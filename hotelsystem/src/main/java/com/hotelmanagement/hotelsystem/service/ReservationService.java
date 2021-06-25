package com.hotelmanagement.hotelsystem.service;

import com.hotelmanagement.hotelsystem.dao.ReservationDao;
import com.hotelmanagement.hotelsystem.entity.ReservationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private InvoiceService invoiceService;

    public ReservationDetails enterReservationDetails(ReservationDetails reservationDetails) {
       ReservationDetails reservationDetails1= reservationDao.save(reservationDetails);
        invoiceService.generateInvoice(reservationDetails.getReservationId());
        return reservationDetails1;

    }

    public List<ReservationDetails> showReservationDetails() {
       return reservationDao.findAll();
    }

    public ReservationDetails updateReservationDetails(ReservationDetails reservationDetails) {
        return reservationDao.save(reservationDetails);
    }

    public void deleteReservationDetails(Long reservationId) {
       ReservationDetails reservationDetails= reservationDao.findReservationById(reservationId);
       reservationDao.delete(reservationDetails);
    }
}
