package com.hotelmanagement.hotelsystem.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eId;
    @NotBlank(message = "employee type can't be blank")
    private String employeeType;
    @Size(min = 2,max = 20,message = "name must be with in 2 to 20 letters")
    private String employeeName;
    private String employeeJoiningDate;
    private String employeeSalary;

    public EmployeeDetails(String employeeType, String employeeName, String employeeJoiningDate, String employeeSalary) {
        this.employeeType = employeeType;
        this.employeeName = employeeName;
        this.employeeJoiningDate = employeeJoiningDate;
        this.employeeSalary = employeeSalary;
    }
}
