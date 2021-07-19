package com.readcsv.readcsvinfo.dao;

import com.readcsv.readcsvinfo.model.DemographyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemographyDao extends JpaRepository<DemographyInfo,Long> {
}
