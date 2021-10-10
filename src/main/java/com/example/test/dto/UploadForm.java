package com.example.test.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {
    private MultipartFile fileData;
    private String id;
    private String name;
    private String pass;
    private String adress;
    private String phone;
    private String email;
    private String emoji;

    public UploadForm() {
    }

    public UploadForm(MultipartFile fileData, String id, String name, String pass, String adress, String phone, String email, String emoji) {
        this.fileData = fileData;
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
        this.emoji = emoji;
    }

    public MultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
