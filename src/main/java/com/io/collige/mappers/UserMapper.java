/*
 * @author : Oguz Kahraman
 * @since : 3.08.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.io.collige.mappers;

import com.io.collige.entitites.User;
import com.io.collige.models.responses.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "token", ignore = true)
    UserResponse mapToModel(User entity);

}
