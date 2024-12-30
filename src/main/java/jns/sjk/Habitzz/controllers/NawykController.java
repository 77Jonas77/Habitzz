package jns.sjk.Habitzz.controllers;

import jakarta.persistence.EntityNotFoundException;
import jns.sjk.Habitzz.models.entities.Nawyk;
import jns.sjk.Habitzz.services.interfaces.INawykService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/nawyk")
public class NawykController {

    private final INawykService nawykService;

    public NawykController(INawykService nawykService) {
        this.nawykService = nawykService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nawyk> getNawykById(@PathVariable int id) {
        Optional<Nawyk> nawyk = nawykService.findById(id);
        return nawyk.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Nawyk> createOrUpdateNawyk(@RequestBody Nawyk nawyk) {
        try {
            Nawyk savedNawyk = nawykService.save(nawyk);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedNawyk);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNawyk(@PathVariable int id) {
        try {
            nawykService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    //get all habits by user id /grupaId
}
