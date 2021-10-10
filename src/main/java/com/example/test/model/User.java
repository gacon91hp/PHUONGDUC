package com.example.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "tbluser")
public class User {
    @Id
    @Pattern(regexp = "^(?=.*[a-z]+)(?=.*[A-Z]+)(?=.*[0-9]+)(?=.{0,8}).*$")
    @NotNull
    private String id;
    @Column(name = "username")
    @Pattern(regexp = "^[a-zA-Z]{3,30}+$")
    @NotNull
    private String name;
    @Column(name = "pass")
    @Pattern(regexp = "^(?=.*[a-z]+)(?=.*[A-Z]+)(?=.*[0-9]+)(?=.*[@$!%*#?&()<>^.+-])(?=.{8,32}).*$")
    @NotNull
    private String pass;
    @Column(name = "adress")
    @NotNull
    private String adress;
    @Column(name = "email")
    @Pattern(regexp = "^[\\w]+@([\\w-]+\\.)[\\w-]{2,4}$")
    @NotNull
    private String email;
    @Column(name = "phone")
    @Pattern(regexp = "^[0-9]{3}-[0-9]{4}-[0-9]{4}$")
    @NotNull
    private String phone;
    @Column(name = "emoji")
    private String emoji;
    @Column(name = "role")
    private String role;

    public User() {
    }

    public User(String id, String name, String pass, String adress, String email, String phone, String emoji,String role) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
        this.emoji = emoji;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
