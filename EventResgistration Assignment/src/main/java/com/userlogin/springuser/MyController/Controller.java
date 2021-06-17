package com.userlogin.springuser.MyController;

import com.userlogin.springuser.Entiry.Events;
import com.userlogin.springuser.Entiry.Register;
import com.userlogin.springuser.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Register addUser(@RequestBody Register register){
        return this.userService.addUser(register);
    }

    @GetMapping("/register")
    public List<Register> getUser(){
        return this.userService.getUser();
    }


    @PostMapping("/register/login")
    public String getUserEvents(@RequestBody Register register){
        return this.userService.getUserEvents(register);
    }

    @GetMapping("/register/login/single/{userId}")
    public Register getSingleUser(@PathVariable Long userId){
        return this.userService.getSingleUser(userId);
    }

    @GetMapping("/register/login")
    public List<Events> getEvents(){
        return this.userService.getEvents();
    }
    @PostMapping("/register/event")
    public String userEventRegister(@RequestBody Events events){
        return this.userService.userEventRegister(events);
    }

    @GetMapping("/register/event")
    public List<Events> showUserEvents(){
        return this.userService.showUserEvents();
    }

}
