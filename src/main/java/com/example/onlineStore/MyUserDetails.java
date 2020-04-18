package com.example.onlineStore;

public class MyUserDetails{
    public static String username = "";
    public static String type = "";

    public MyUserDetails() {
    }

    public static void login(String username1, String type1){
        username = username1;
        type = type1;
    }

    public static void logout(){
        username = "";
        type = "";
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        MyUserDetails.username = username;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        MyUserDetails.type = type;
    }
}