package com.userlogin.springuser.Service;

import com.userlogin.springuser.Entiry.Events;
import com.userlogin.springuser.Entiry.Register;
import com.userlogin.springuser.dao.EventDao;
import com.userlogin.springuser.dao.UserDao;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    List<Events> evn=null;
    static int f=0;

    UserServiceImpl(){

        evn=new ArrayList<>();
        evn.add(new Events("Singing","Noida"));
        evn.add(new Events("Dancing","Delhi"));
        evn.add(new Events("Playing","Mumbai"));
        evn.add(new Events("IPL","Pune"));
        evn.add(new Events("NFL","USA"));
    }

    @Autowired
    private UserDao userDao;
    List<Register> list=null;

    @Autowired
    private EventDao eventDao;

    @Override
    public Register addUser(Register register) {
        userDao.save(register);
        return register;
    }

    @Override
    public List<Register> getUser() {
        list=userDao.findAll();
        return list;
    }

    @Override
    public String getUserEvents(Register register) {

        System.out.println(register.getUserId()+" ---- "+register.getUserPass());
        Register regList=userDao.findByuserId(register.getUserId());
        Register reg=userDao.findByuserPass(register.getUserPass());
        System.out.println(regList+" -- "+reg);

        String s=null;

        if((regList!=null) && (reg!=null)){
            s="User login successfully !!!";
            f=1;
        }
        else {
            s = "User login failed !!! try again !!!";
            f=0;
        }
        return s;
    }

    @Override
    public List<Events> getEvents() {
        if(f==1){
            return evn;
        }
        return null;
    }

    @Override
    public String userEventRegister(Events events) {
        eventDao.save(events);
        return "Event registered successfully !!!";
    }

    @Override
    public List<Events> showUserEvents() {
        return eventDao.findAll();
    }

    @Override
    public Register getSingleUser(Long userId) {
        Register r=null;
        for(Register register:userDao.findAll()){
            if(register.getUserId()==userId){
                r=register;
                break;
            }
        }
        return r;
    }


}
