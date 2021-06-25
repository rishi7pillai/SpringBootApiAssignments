package com.hotelmanagement.hotelsystem.service;

import com.hotelmanagement.hotelsystem.dao.EmployeeDao;
import com.hotelmanagement.hotelsystem.entity.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<EmployeeDetails> showEmployeeDetails() {
        return employeeDao.findAll();
    }

    public EmployeeDetails enterEmployeeDetails(EmployeeDetails employeeDetails) {
        System.out.println(employeeDetails.toString());
        EmployeeDetails emp=employeeDao.save(employeeDetails);
        System.out.println(emp.toString());
        return emp;
    }

    public EmployeeDetails updateEmployeeDetails(EmployeeDetails employeeDetails) {
       return employeeDao.save(employeeDetails);
    }

    public void deleteEmployeeDetails(Long eId) {
        EmployeeDetails employeeDetails=employeeDao.findEmployeeById(eId);
        employeeDao.delete(employeeDetails);
    }
}
