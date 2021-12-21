/*
 * @author : Oguz Kahraman
 * @since : 3.08.2021
 *
 * Copyright - Tamir Guru App Java API
 **/
package com.dota.tamirguru.mappers;

import com.dota.tamirguru.entitites.User;
import com.dota.tamirguru.models.requests.user.UserCreateRequest;
import com.dota.tamirguru.models.responses.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper {

    @Mapping(target = "token", ignore = true)
    UserResponse mapToModel(User entity);

    @Mapping(target = "password", ignore = true)
    @Mapping(source = "name", target = "name", qualifiedByName = "capitalize")
    @Mapping(source = "surname", target = "surname", qualifiedByName = "capitalize")
    @Mapping(source = "email", target = "email", qualifiedByName = "lowercase")
    User mapToModel(UserCreateRequest request);

}
