package com.example.test.jwt;



public class AuthenticateReq {
    private String name;
    private String pass;

    public AuthenticateReq() {
    }

    public AuthenticateReq(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}