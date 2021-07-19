package com.readcsv.readcsvinfo.dao;

import com.readcsv.readcsvinfo.model.AddressInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<AddressInfo,Long> {
}
