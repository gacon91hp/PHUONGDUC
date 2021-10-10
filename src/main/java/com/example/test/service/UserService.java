package com.example.test.service;

import com.example.test.dto.UploadForm;
import com.example.test.dto.UserDTO;
import com.example.test.jwt.AuthenticateReq;
import com.example.test.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService  {
    // sign-up
    public String createUser(UploadForm uploadForm) throws IOException;
    public User updateUser(String id,UserDTO userDTO);
    public String updateFile(MultipartFile fileData,String id) throws IOException;
    public UserDTO userDtail(String id);
    public Page<User> userLists(int page);
    public String deleteUser(String id);
    public String login(AuthenticateReq req);
}
