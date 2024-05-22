package br.com.weaponmanagement.service.mapper;

import br.com.weaponmanagement.model.request.UserRequest;
import br.com.weaponmanagement.persistence.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper implements Mapper<UserRequest, User> {

    @Override
    public User map(UserRequest input) {
        if(input == null) {
            return null;
        }

        User user = new User();
        user.setName(input.getName());
        user.setEmail(input.getEmail());

        return user;


    }
}
