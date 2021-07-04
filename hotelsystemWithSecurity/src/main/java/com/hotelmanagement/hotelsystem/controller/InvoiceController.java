package com.hotelmanagement.hotelsystem.controller;

import com.hotelmanagement.hotelsystem.dao.InvoiceDao;
import com.hotelmanagement.hotelsystem.entity.InvoiceDetails;
import com.hotelmanagement.hotelsystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceDao invoiceDao;

    @GetMapping("/generate-invoice/{reservationId}")
    public InvoiceDetails generateSingleInvoice(@PathVariable Long reservationId){
        return invoiceService.generateSingleInvoice(reservationId);
    }

    @GetMapping("/show-all-invoice")
    public List<InvoiceDetails> showAllInvoice(){
        return invoiceDao.findAll();
    }
}
