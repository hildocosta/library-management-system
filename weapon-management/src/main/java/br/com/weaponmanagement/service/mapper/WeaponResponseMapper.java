package br.com.weaponmanagement.service.mapper;

import br.com.weaponmanagement.model.response.WeaponResponse;
import br.com.weaponmanagement.persistence.entity.Weapon;
import org.springframework.stereotype.Component;

@Component
public class WeaponResponseMapper implements Mapper<Weapon, WeaponResponse>{


    @Override
    public WeaponResponse map(Weapon input) {
        if(input == null){
            return  null;
        }

        WeaponResponse weaponResponse = new WeaponResponse();

        weaponResponse.setId(input.getId());
        weaponResponse.setTipo(input.getTipo());
        weaponResponse.setPatrimonio(input.getPatrimonio());

        return weaponResponse;

    }
}
