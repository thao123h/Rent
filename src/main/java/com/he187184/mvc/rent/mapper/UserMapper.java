package com.he187184.mvc.rent.mapper;

import com.he187184.mvc.rent.dto.request.SignupRequest;
import com.he187184.mvc.rent.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface UserMapper {

    SignupRequest toDTO(User user);

    User toEntity(SignupRequest dto);
}
