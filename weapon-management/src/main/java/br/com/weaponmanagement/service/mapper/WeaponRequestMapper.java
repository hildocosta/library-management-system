package br.com.weaponmanagement.service.mapper;


import br.com.weaponmanagement.model.request.WeaponRequest;
import br.com.weaponmanagement.persistence.entity.Weapon;
import org.springframework.stereotype.Component;

@Component
public class WeaponRequestMapper implements Mapper<WeaponRequest, Weapon> {

    @Override
    public Weapon map(WeaponRequest input) {
        if(input == null){
            return  null;
        }

        Weapon weapon = new Weapon();
        weapon.setTipo(input.getTipo());
        weapon.setPatrimonio(input.getPatrimonio());

        return weapon;
    }
}
