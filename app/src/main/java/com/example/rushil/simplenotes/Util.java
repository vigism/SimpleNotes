package com.example.rushil.simplenotes;

/**
 * Created by Rushil on 8/10/2017.
 */

public class Util {

    public static boolean usernameMatchRequirements(String username){
        if(username.length()>2 && username.length()<15){
            return true;
        }
        return false;
    }

    public static boolean passwordMatchRequirements(String password){
        if(password.length()>2 && password.length()<10){
            return true;
        }else{
            return false;
        }
    }
}
