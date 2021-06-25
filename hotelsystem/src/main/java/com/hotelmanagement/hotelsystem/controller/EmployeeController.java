package com.hotelmanagement.hotelsystem.controller;

import com.hotelmanagement.hotelsystem.entity.EmployeeDetails;
import com.hotelmanagement.hotelsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
   @Autowired
   private EmployeeService employeeService;

   @GetMapping("/show-employee-details")
    public List<EmployeeDetails> showEmployeeDetails(){
      return employeeService.showEmployeeDetails();
   }

   @PostMapping("/enter-employee-details")
    public EmployeeDetails enterEmployeeDetails(@RequestBody EmployeeDetails employeeDetails){
      return employeeService.enterEmployeeDetails(employeeDetails);

   }

   @PutMapping("/update-employee-details")
    public EmployeeDetails updateEmployeeDetails(@RequestBody EmployeeDetails employeeDetails){
       return employeeService.updateEmployeeDetails(employeeDetails);
   }

   @DeleteMapping("/delete-employee-details/{eId}")
    public ResponseEntity<HttpStatus> deleteEmployeeDetails(@PathVariable Long eId){

       try{
           employeeService.deleteEmployeeDetails(eId);
           return new ResponseEntity<>(HttpStatus.OK);
       } catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }

   }
}
