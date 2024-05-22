package br.com.weaponmanagement.service.mapper;

import br.com.weaponmanagement.model.response.MovementResponse;
import br.com.weaponmanagement.persistence.entity.Movement;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class MovementResponseMapper implements Mapper<Movement, MovementResponse> {


    @Override
    public MovementResponse map(Movement input) {
        if(input == null){
            return  null;
        }

        MovementResponse movementResponse = new MovementResponse();
        movementResponse.setId(input.getId());
        movementResponse.setWeaponId(input.getId());
        movementResponse.setUserId(input.getId());
        movementResponse.setAction(input.getAction());
        movementResponse.setDate(input.getDate());

        return movementResponse;
    }
}
