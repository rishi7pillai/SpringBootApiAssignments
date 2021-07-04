package com.hotelmanagement.hotelsystem.dao;

import com.hotelmanagement.hotelsystem.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeDetails,Long> {

    @Query("select e from EmployeeDetails e where e.eId=:eId")
    public EmployeeDetails findEmployeeById(@Param("eId") Long eId);
}
