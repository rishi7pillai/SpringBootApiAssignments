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
public class AddressInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long aid;
    @CsvBindByName(column = "County")
    private String country;
    @CsvBindByName(column = "City")
    private String city;
    @CsvBindByName(column = "State")
    private String state;
    @CsvBindByName(column = "Zip")
    private String zip;
    @CsvBindByName(column = "Region")
    private String region;

}