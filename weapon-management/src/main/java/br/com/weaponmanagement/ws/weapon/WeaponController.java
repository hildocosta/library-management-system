package br.com.weaponmanagement.ws.weapon;

import br.com.weaponmanagement.model.request.WeaponRequest;
import br.com.weaponmanagement.model.response.WeaponResponse;
import br.com.weaponmanagement.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/weapons")
public class WeaponController {

    @Autowired
    private WeaponService weaponService;

    @PostMapping
    public ResponseEntity<WeaponResponse> createWeapon(@RequestBody WeaponRequest weaponRequest) {
        WeaponResponse weaponResponse = weaponService.create(weaponRequest);
        return ResponseEntity.ok(weaponResponse);
    }

    @GetMapping
    public ResponseEntity<Page<WeaponResponse>> getAllWeapons(Pageable pageable) {
        Page<WeaponResponse> weapons = weaponService.getAll(pageable);
        return ResponseEntity.ok(weapons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeaponResponse> getWeaponById(@PathVariable Long id) {
        Optional<WeaponResponse> weaponResponse = weaponService.get(id);
        return weaponResponse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeaponResponse> updateWeapon(@PathVariable Long id, @RequestBody WeaponRequest weaponRequest) {
        Optional<WeaponResponse> weaponResponse = weaponService.update(id, weaponRequest);
        return weaponResponse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeapon(@PathVariable Long id) {
        if (weaponService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
