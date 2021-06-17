package com.userlogin.springuser.dao;

import com.userlogin.springuser.Entiry.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Register, Long> {


    Register findByuserId(Long userId);

    Register findByuserPass(String userPass);
}
