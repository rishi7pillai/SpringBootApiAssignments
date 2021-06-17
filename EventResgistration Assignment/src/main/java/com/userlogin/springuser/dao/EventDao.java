package com.userlogin.springuser.dao;

import com.userlogin.springuser.Entiry.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDao extends JpaRepository<Events,String> {
}
