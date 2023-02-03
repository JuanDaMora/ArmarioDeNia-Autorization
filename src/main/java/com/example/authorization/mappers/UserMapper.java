package com.example.authorization.mappers;

import com.example.authorization.dto.UserDTO;
import com.example.authorization.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @autor Juan David Morantes Vergara
 */
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Mapping User to UserDTO
    UserDTO toUserDTO(User user);

    // Mapping UserDTO to User
    User toUser(UserDTO userDTO);
}
