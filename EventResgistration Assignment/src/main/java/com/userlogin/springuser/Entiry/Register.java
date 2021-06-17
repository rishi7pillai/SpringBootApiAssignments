package com.userlogin.springuser.Entiry;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class  Register{

    @Id
    private long userId;
    private String userPass;
    private String userName;

    public Register() {
        super();
    }

    public Register(long userId, String userPass, String userName) {
        this.userId = userId;
        this.userPass = userPass;
        this.userName = userName;
    }

    public Register(String userPass, String userName) {
        this.userPass = userPass;
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}