package com.hotelmanagement.hotelsystem.service;

import com.hotelmanagement.hotelsystem.dao.InvoiceDao;
import com.hotelmanagement.hotelsystem.dao.MealDao;
import com.hotelmanagement.hotelsystem.dao.ReservationDao;
import com.hotelmanagement.hotelsystem.dao.RoomDao;
import com.hotelmanagement.hotelsystem.entity.InvoiceDetails;
import com.hotelmanagement.hotelsystem.entity.MealDetails;
import com.hotelmanagement.hotelsystem.entity.ReservationDetails;
import com.hotelmanagement.hotelsystem.entity.RoomDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvoiceService {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private RoomDao roomDao;
    @Autowired
    private MealDao mealDao;

    public void generateInvoice(Long reservationId) {

        InvoiceDetails invoiceDetails = new InvoiceDetails();

        try{
            invoiceDetails.setReservationId(reservationId);
            ReservationDetails reservationDetails= reservationDao.findReservationById(reservationId);
            invoiceDetails.setCheckInDate(reservationDetails.getCheckInDate());
            invoiceDetails.setCheckOutDate(reservationDetails.getCheckOutDate());
            invoiceDetails.setUserName(reservationDetails.getUserName());
            invoiceDetails.setUserNo(reservationDetails.getUserNo());
            Long checkIn = reservationDetails.getCheckInDate();
            Long checkOut= reservationDetails.getCheckOutDate();
            RoomDetails roomDetails=roomDao.getRoomByRoomNo(reservationDetails.getRoomId());
            invoiceDetails.setRoomNo(roomDetails.getRoomNo());
            invoiceDetails.setRoomType(roomDetails.getRoomType());
            invoiceDetails.setRoomPrice(roomDetails.getRoomPrice());
            Long roomPrice = roomDetails.getRoomPrice();

            MealDetails mealDetails = mealDao.getMealById(reservationDetails.getMealId());
            invoiceDetails.setMealType(mealDetails.getMealType());
            invoiceDetails.setMealPrice(mealDetails.getMealPrice());
            Long mealPrice = mealDetails.getMealPrice();
            Long total= ((checkOut-checkIn)*roomPrice)+mealPrice;
            invoiceDetails.setTotalPrice(total);

            System.out.println(invoiceDetails.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        invoiceDao.save(invoiceDetails);
    }


    public InvoiceDetails generateSingleInvoice(Long reservationId) {
           return invoiceDao.getInvoiceByReservation(reservationId);
    }
}
