package jns.sjk.Habitzz.controllers;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.models.entities.Grupa;
import jns.sjk.Habitzz.services.interfaces.IGrupaService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grupa")
public class GrupaController {

    private final IGrupaService grupaService;

    public GrupaController(IGrupaService grupaService) {
        this.grupaService = grupaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupa> getGrupa(@PathVariable Integer id) {
        try {
            Grupa grupa = grupaService.findById(id);
            return ResponseEntity.ok(grupa);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Grupa> createOrUpdateGrupa(@RequestBody Grupa grupa) {
        try {
            Grupa savedGrupa = grupaService.save(grupa);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedGrupa);
        } catch (BadRequestException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupa(@PathVariable Integer id) {
        try {
            grupaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    //get all groups by user id
}
