package com.hotelmanagement.hotelsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserOneRepo extends JpaRepository<UserOne,Integer> {
     Optional<UserOne> findByUserName(String userName);
}
