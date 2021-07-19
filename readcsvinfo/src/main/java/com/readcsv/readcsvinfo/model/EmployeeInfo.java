package com.readcsv.readcsvinfo.model;


import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long eid;
    @CsvBindByName(column = "Emp ID")
    private String employeeId;
    @CsvBindByName(column = "First Name")
    private String firstName;
    @CsvBindByName(column = "Last Name")
    private String lastName;
    @CsvBindByName(column = "Gender")
    private String gender;
    @CsvBindByName(column = "E Mail")
    private String email;



}
