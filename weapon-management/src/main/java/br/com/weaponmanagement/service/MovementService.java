package br.com.weaponmanagement.service;


import br.com.weaponmanagement.model.request.MovementRequest;
import br.com.weaponmanagement.model.response.MovementResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MovementService {

   MovementResponse create(MovementRequest movementRequest);

    Page<MovementResponse> getAll(Pageable pageable);

    Optional<MovementResponse> update(Long id, MovementRequest movementRequest);

    Optional<MovementResponse> get(Long id);

    boolean delete(Long id);
}
