package com.example.test.mapper;

import com.example.test.dto.UserDTO;
import com.example.test.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring"
        , unmappedTargetPolicy = ReportingPolicy.IGNORE
        , uses = {}
)
public interface UserMapper {
    UserDTO toDTO(User user);
    User fromDTO(UserDTO userDTO);
}
