package com.userlogin.springuser.Service;


import com.userlogin.springuser.Entiry.Events;
import com.userlogin.springuser.Entiry.Register;

import java.util.List;

public interface UserService {

    Register addUser(Register register);

    List<Register> getUser();

    String getUserEvents(Register register);

    List<Events> getEvents();

    String userEventRegister(Events events);

    List<Events> showUserEvents();

    Register getSingleUser(Long userId);
}
