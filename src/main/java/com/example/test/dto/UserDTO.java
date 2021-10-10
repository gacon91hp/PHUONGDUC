package com.example.test.dto;

import javax.persistence.Column;

public class UserDTO {
    private String id;
    private String name;
    private String pass;
    private String adress;
    private String email;
    private String phone;
    private String emoji;

    public UserDTO() {
    }

    public UserDTO(String id, String name, String pass, String adress, String email, String phone, String emoji) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
        this.emoji = emoji;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
