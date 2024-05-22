package br.com.weaponmanagement.persistence.repository;

import br.com.weaponmanagement.persistence.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}
