package br.com.weaponmanagement.service.mapper;

import br.com.weaponmanagement.model.response.UserResponse;
import br.com.weaponmanagement.persistence.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements Mapper<User, UserResponse> {


    @Override
    public UserResponse map(User input) {
        if(input == null){
            return  null;
    }

        UserResponse userResponse = new UserResponse();
        userResponse.setId(input.getId());
        userResponse.setName(input.getName());
        userResponse.setEmail(input.getEmail());

        return userResponse;

    }
}
