package br.com.weaponmanagement.service;

import br.com.weaponmanagement.model.request.WeaponRequest;
import br.com.weaponmanagement.model.response.WeaponResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface WeaponService {

    WeaponResponse create(WeaponRequest weaponRequest);

    Page<WeaponResponse> getAll(Pageable pageable);

    Optional<WeaponResponse> update(Long id, WeaponRequest weaponRequest);

    Optional<WeaponResponse> get(Long id);

    boolean delete(Long id);
}
