package br.com.weaponmanagement.service.mapper;

import br.com.weaponmanagement.model.request.MovementRequest;
import br.com.weaponmanagement.model.response.MovementResponse;
import br.com.weaponmanagement.persistence.entity.Movement;
import br.com.weaponmanagement.persistence.repository.MovementRepository;
import br.com.weaponmanagement.service.MovementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
public class MovementServiceImpl implements MovementService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovementService.class);

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private Mapper<MovementRequest, Movement> requestMapper;

    @Autowired
    private Mapper<Movement, MovementResponse> responseMapper;


    @Override
    public MovementResponse create(MovementRequest movementRequest) {
        LOGGER.info("Criando o registro do movimento");
        notNull(movementRequest, "Request Invalida");

        Movement movement = this.requestMapper.map(movementRequest);
        Movement savedMovement = movementRepository.saveAndFlush(movement);

        return this.responseMapper.map(savedMovement);
    }

    @Override
    public Page<MovementResponse> getAll(Pageable pageable) {
        LOGGER.info("Buscando todos os movimentos");
        notNull(pageable, "Pagina Invalida");

        return movementRepository.findAll(pageable).map(movement -> this.responseMapper.map(movement));
    }

    @Override
    public Optional<MovementResponse> update(Long id, MovementRequest movementRequest) {
        LOGGER.info("Atualizando movimento");
        notNull(id, "ID Invalido");

        Movement movementUpdate = this.requestMapper.map(movementRequest);

        return movementRepository.findById(id)
                .map(movement -> {
                    movement.setAction(movementUpdate.getAction());
                    movement.setDate(movementUpdate.getDate());
                    movement.setUser(movementUpdate.getUser());
                    movement.setWeapon(movementUpdate.getWeapon());

                    return responseMapper.map(movementRepository.saveAndFlush(movement));
                });
    }

    @Override
    public Optional<MovementResponse> get(Long id) {
        LOGGER.info("Buscando movimento");
        notNull(id, "ID Invalido");

        return movementRepository.findById(id).map(this.responseMapper::map);
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.info("Removendo movimento");
        notNull(id, "ID Invalido");

        try {
            movementRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            LOGGER.warn("Erro ao remover movimento {}", id);
            return false;
        }
    }
}