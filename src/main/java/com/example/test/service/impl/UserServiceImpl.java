package com.example.test.service.impl;


import com.example.test.dto.UploadForm;
import com.example.test.dto.UserDTO;
import com.example.test.jwt.AuthenticateReq;
import com.example.test.jwt.JwtTokenUtil;
import com.example.test.mapper.UserMapper;
import com.example.test.model.User;
import com.example.test.random.RandomString;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RandomString randomString;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String createUser(UploadForm uploadForm) throws IOException {
            User user = userRepository.findByName(uploadForm.getName());
            if(user != null) {
                return "username is duplicate";
            }else {
                MultipartFile fileData = uploadForm.getFileData();
                if(fileData.getContentType().equals("image/jpeg") || fileData.getContentType().equals("image/png") || fileData.getContentType().equals("image/jpg") || fileData.getContentType().equals("image/bmp")){
                    String nameFile =randomString.genString()+ System.nanoTime() + "-" + uploadForm.getFileData().getOriginalFilename()  ;
                    File serverFile = new File("D:\\images/" + nameFile);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(uploadForm.getFileData().getBytes());
                    stream.close();
                    BufferedImage img = ImageIO.read(serverFile);
                    if(img.getHeight() == 512 && img.getWidth() == 512){
                        String password = BCrypt.hashpw(uploadForm.getPass(), BCrypt.gensalt(12));
                       userRepository.save(new User(randomString.genString(),uploadForm.getName(),password,uploadForm.getAdress(),uploadForm.getEmail(),uploadForm.getPhone(),nameFile,"USER"));
                        return "tạo username successful";
                    }else {
                        serverFile.delete();
                        return "errosize";
                    }
                }else {
                    return "errorformat";
                }
            }
    }

    @Override
    public User updateUser(String id, UserDTO userDTO) {
        User user = userRepository.findById(id);
        user.setName(userDTO.getName());
        user.setPass(BCrypt.hashpw(userDTO.getPass(), BCrypt.gensalt(12)));
        user.setAdress(userDTO.getAdress());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        return userRepository.save(user);
    }

    @Override
    public String updateFile(MultipartFile fileData,String id) throws IOException {
        User user = userRepository.findById(id);
        if(fileData.getContentType().equals("image/jpeg") || fileData.getContentType().equals("image/png") || fileData.getContentType().equals("image/jpg") || fileData.getContentType().equals("image/bmp")){
            String nameFile =randomString.genString()+ System.nanoTime() + "-" + fileData.getOriginalFilename()  ;
            File serverFile = new File("D:\\images/" + nameFile);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(fileData.getBytes());
            stream.close();
            BufferedImage img = ImageIO.read(serverFile);
            if(img.getHeight() == 512 && img.getWidth() == 512){
                File serverFileDel = new File("D:\\images/" + user.getEmoji());
                serverFileDel.delete();
                user.setEmoji(nameFile);
                userRepository.save(user);
                return "update file successful";
            }else {
                serverFile.delete();
                return "errosize";
            }
        }else {
            return "errorformat";
        }

    }

    @Override
    public UserDTO userDtail(String id) {
        User user = userRepository.findById(id);
        return userMapper.toDTO(user);
    }

    @Override
    public Page<User> userLists(int page) {
        Page<User> userPage = userRepository.findAll(PageRequest.of(page,5));
        return userPage;
    }

    @Override
    public String deleteUser(String id) {
        User user = userRepository.findById(id);
        File serverFileDel = new File("D:\\images/" + user.getEmoji());
        serverFileDel.delete();
        userRepository.delete(user);
        return " successful delete";
    }

    @Override
    public String login(AuthenticateReq req) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getName(),
                        req.getPass()
                )
        );
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Gen token
        String token = jwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal());

        return token;
    }


}
