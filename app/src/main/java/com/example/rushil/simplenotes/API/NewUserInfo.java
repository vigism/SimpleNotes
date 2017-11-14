package com.example.rushil.simplenotes.API;

/**
 * Created by Rushil on 8/9/2017.
 */

public class NewUserInfo {

    private String username;
    private String[] notes;
    private String password;

    public NewUserInfo(String username, String password){
        this.notes=new String[0];
        this.username=username;
        this.password=password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password){
        this.password=password;
    }
}
