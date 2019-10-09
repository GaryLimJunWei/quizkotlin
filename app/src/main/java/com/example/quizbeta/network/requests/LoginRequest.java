package com.example.quizbeta.network.requests;

public class LoginRequest {

    String password;
    int adminId;

    public LoginRequest(int adminId, String password){
        this.adminId = adminId;
        this.password = password;
    }
}
