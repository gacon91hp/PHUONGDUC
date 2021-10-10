package com.example.test.controller;

import com.example.test.dto.UploadForm;
import com.example.test.dto.UserDTO;
import com.example.test.jwt.AuthenticateReq;
import com.example.test.model.User;

import com.example.test.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;



@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("create-user")
    public String createUser(@ModelAttribute("uploadfrom")UploadForm uploadForm) throws IOException {
        return userService.createUser(uploadForm);
    }

    @PutMapping("update-user/{id}")
    public User updateUser(@PathVariable("id")String id,@RequestBody UserDTO userDTO){
        return userService.updateUser(id,userDTO);
    }

    @PutMapping("update-user-file/{id}")
    public String updateUserFile(@PathVariable("id")String id,@ModelAttribute("uploadfrom")UploadForm uploadForm) throws IOException {
        MultipartFile fileData = uploadForm.getFileData();
        return userService.updateFile(fileData,id);
    }

    @GetMapping("user-detail/{id}")
    public UserDTO userDetail(@PathVariable("id")String id){
        return userService.userDtail(id);
    }

    @GetMapping("user-list/{page}")
    public Page<User> userList(@PathVariable("page")int page){
        return userService.userLists(page);
    }

    @DeleteMapping("delete-user/{id}")
    public String deleteUser(@PathVariable("id")String id){
        return userService.deleteUser(id);
    }

    @PostMapping("login")
    public String login(@RequestBody AuthenticateReq req){
        return userService.login(req);
    }

}
