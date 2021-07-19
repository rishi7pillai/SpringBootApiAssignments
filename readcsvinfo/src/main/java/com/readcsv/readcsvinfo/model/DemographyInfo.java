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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DemographyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long did;
    @CsvBindByName(column = "Father's Name")
    private String fatherName;
    @CsvBindByName(column = "Mother's Name")
    private String motherName;
    @CsvBindByName(column = "Date of Birth")
    private String dob;
    @CsvBindByName(column = "Age in Yrs.")
    private String age;
    @CsvBindByName(column = "Weight in Kgs.")
    private String weight;
}
