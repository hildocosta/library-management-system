package br.com.weaponmanagement.ws.weapon;

import br.com.weaponmanagement.model.request.MovementRequest;
import br.com.weaponmanagement.model.response.MovementResponse;
import br.com.weaponmanagement.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movements")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @PostMapping
    public ResponseEntity<MovementResponse> createMovement(@RequestBody MovementRequest movementRequest) {
        MovementResponse movementResponse = movementService.create(movementRequest);
        return new ResponseEntity<>(movementResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<MovementResponse>> getAllMovements(Pageable pageable) {
        Page<MovementResponse> movements = movementService.getAll(pageable);
        return new ResponseEntity<>(movements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementResponse> getMovement(@PathVariable Long id) {
        Optional<MovementResponse> movementResponse = movementService.get(id);
        return movementResponse.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementResponse> updateMovement(@PathVariable Long id, @RequestBody MovementRequest movementRequest) {
        Optional<MovementResponse> movementResponse = movementService.update(id, movementRequest);
        return movementResponse.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable Long id) {
        boolean isDeleted = movementService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

