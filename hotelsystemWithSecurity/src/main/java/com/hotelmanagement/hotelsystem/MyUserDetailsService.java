package com.hotelmanagement.hotelsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserOneRepo userOneRepo;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         return new User("foo","foo",new ArrayList<>());


        Optional<UserOne> user=userOneRepo.findByUserName(username);

       user.orElseThrow(()->new UsernameNotFoundException("Not found : "+username));

       return user.map(MyUserDetails::new).get();
    }
}
