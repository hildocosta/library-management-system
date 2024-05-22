package br.com.weaponmanagement.persistence.repository;

import br.com.weaponmanagement.persistence.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {
}
