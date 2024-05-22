package br.com.weaponmanagement.service.mapper;

import br.com.weaponmanagement.model.request.WeaponRequest;
import br.com.weaponmanagement.model.response.WeaponResponse;
import br.com.weaponmanagement.persistence.entity.Weapon;
import br.com.weaponmanagement.persistence.repository.WeaponRepository;
import br.com.weaponmanagement.service.WeaponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
public class WeaponServiceImpl implements WeaponService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeaponService.class);

    @Autowired
    private WeaponRepository weaponRepository;

    @Autowired
    private Mapper<WeaponRequest, Weapon> requestMapper;

    @Autowired
    private Mapper<Weapon, WeaponResponse> responseMapper;



    @Override
    public WeaponResponse create(WeaponRequest weaponRequest) {
        LOGGER.info(" Criando o registro da arma");
        notNull(weaponRequest, " Request Invalida");

        Weapon weapon = this.requestMapper.map(weaponRequest);
        Weapon savedWeapon = weaponRepository.saveAndFlush(weapon);

        return  this.responseMapper.map(savedWeapon);

    }


    @Override
    public Page<WeaponResponse> getAll(Pageable pageable) {
        LOGGER.info(" Buscando todas as  armas");
        notNull(pageable, " Pagina Invalida");

        return weaponRepository.findAll(pageable).map(weapon -> this.responseMapper.map(weapon));


    }

    @Override
    public Optional<WeaponResponse> update(Long id, WeaponRequest weaponRequest) {
        LOGGER.info(" Atualizando  arma");
        notNull(id, " ID Invalido");

        Weapon weaponUpdate = this.requestMapper.map((weaponRequest));

        return weaponRepository.findById(id)
                .map(weapon -> {

                    weapon.setTipo((weaponUpdate.getTipo()));
                    weapon.setPatrimonio((weaponUpdate.getPatrimonio()));

                    return responseMapper.map(weaponRepository.saveAndFlush(weapon));


                });

    }

    @Override
    public Optional<WeaponResponse> get(Long id) {
        LOGGER.info(" Buscando  arma");
        notNull(id, " ID Invalido");

        return weaponRepository.findById(id).map(this.responseMapper::map);
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.info(" Removendo  arma");
        notNull(id, " ID Invalido");

        try{

            weaponRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            LOGGER.warn(" Erro ao remover arma {}", id);
            return false;
        }
    }
}
