package br.com.weaponmanagement.service.mapper;

import br.com.weaponmanagement.model.request.MovementRequest;
import br.com.weaponmanagement.persistence.entity.Movement;
import br.com.weaponmanagement.persistence.entity.User;
import br.com.weaponmanagement.persistence.entity.Weapon;
import br.com.weaponmanagement.persistence.repository.UserRepository;
import br.com.weaponmanagement.persistence.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovementRequestMapper implements Mapper<MovementRequest, Movement> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeaponRepository weaponRepository;

    @Override
    public Movement map(MovementRequest input) {
        if (input == null) {
            return null;
        }

        Movement movement = new Movement();
        movement.setAction(input.getAction());
        movement.setDate(input.getDate());

        User user = userRepository.findById(input.getUserId()).orElse(null);
        Weapon weapon = weaponRepository.findById(input.getWeaponId()).orElse(null);

        movement.setUser(user);
        movement.setWeapon(weapon);

        return movement;
    }
}
