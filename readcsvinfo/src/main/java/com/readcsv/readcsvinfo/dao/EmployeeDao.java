package com.readcsv.readcsvinfo.dao;

import com.readcsv.readcsvinfo.model.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeInfo,Long> {
}
